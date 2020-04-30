package com.example.photoavatar


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.media.browse.MediaBrowser
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.util.jar.Manifest

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    private lateinit var rootView: View
    private lateinit var changeAvatarPhoto: Button
    private lateinit var avatarIm: ImageView
    private var photoPath: String? = null
    private var selectedPhotoFile: File? = null
    val REQUEST_TAKE_PHOTO=1
    private lateinit var preferencesAvatar: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        avatarIm = rootView.findViewById(R.id.imageView2)

        try {
            preferencesAvatar = context!!.getSharedPreferences("Avatar",0)
            val pathPhotoAvatar = preferencesAvatar.getString("uri",null)
            avatarIm.setImageURI(Uri.parse(pathPhotoAvatar))
            Toast.makeText(activity as Context,"sdsd "+ pathPhotoAvatar,Toast.LENGTH_SHORT).show()

        }catch (e: Exception){
            Toast.makeText(activity as Context,"No avatar photos on local",Toast.LENGTH_SHORT).show()
        }

        avatarIm.setOnClickListener {
            getPermissions()
//            getPermissionsForCamera()
//            getPermissionsForGalery()
        }

        return rootView
    }

    private fun getPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val cameraGranted = ContextCompat.checkSelfPermission(activity as Context,android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
            val galleryGranted = ContextCompat.checkSelfPermission(activity as Context, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
            if (cameraGranted && galleryGranted) {
                imageChooserDialog()
            } else {
                requestPermissions(
                    arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    RequestConstants.AVATAR_PERMISSION_REQUEST
                )
            }
        } else {
            imageChooserDialog()
        }
    }

    private fun imageChooserDialog() {
        val adapter: ArrayAdapter<String> = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1)
        adapter.add("Camera")
        adapter.add("Gallery")
        AlertDialog.Builder(activity as Context)
            .setTitle("Change avatar")
            .setAdapter(adapter) { dialog, which ->
                if (which == 0) {
                    openCamera()
                } else {
                    openGallery()
                }
            }
            .create()
            .show()
    }

    private fun openGallery(){
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true)
            startActivityForResult(intent, RequestConstants.GALLERY)

    }

    private fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(context!!.packageManager) !=null){
            var photoFile: File? = null
            try{
                photoFile=createImageFile()
            }catch (e: IOException){}
            if(photoFile != null){
                val photoUri = FileProvider.getUriForFile(
                    activity as Context,
                    "${context?.packageName}.provider",
                    photoFile
                )
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                startActivityForResult(intent,REQUEST_TAKE_PHOTO)
            }
        }
    }

    private fun createImageFile(): File? {
        val filename = "MyAvatars"
        val storageDir = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            filename,
            ".jpg",
            storageDir
        )
        photoPath = image.absolutePath
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        preferencesAvatar = context!!.getSharedPreferences("Avatar",0)
        if (resultCode == Activity.RESULT_OK && requestCode==REQUEST_TAKE_PHOTO) {
            preferencesAvatar.edit().clear().commit()
            preferencesAvatar.edit().putString("uri",photoPath).commit()
            avatarIm.setImageURI(Uri.parse(photoPath))
        } else if (requestCode == RequestConstants.GALLERY) {
            val image = data?.data
            preferencesAvatar.edit().clear().commit()
            preferencesAvatar.edit().putString("uri",image.toString()).commit()
            avatarIm.setImageURI(image)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RequestConstants.AVATAR_CAMERA_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            }
            return
        } else if (requestCode == RequestConstants.AVATAR_GALLERY_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
            }
            return
        }
        else if (requestCode == RequestConstants.AVATAR_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                imageChooserDialog()
            }
        }
    }
}


