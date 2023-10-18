package com.example.protectly.Camera

import android.Manifest
import android.app.Activity
import android.app.Notification.Action
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.protectly.R
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class RekamFragment : Fragment() {

    private lateinit var rekamImg: ImageView
    private lateinit var captureButton: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rekam, container, false)
        rekamImg = view.findViewById(R.id.rekam_img)
        captureButton = view.findViewById(R.id.btn_capture)

        captureButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startCameraCapture()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(), arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE
                )
            }
        }

        return view
    }

    private fun startCameraCapture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(requireContext().packageManager) != null){
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1)
            intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 1024 * 1024)

            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        }
        else {
            Toast.makeText(requireContext(), "Camera app not found.", Toast.LENGTH_SHORT).show()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCameraCapture()
            } else {
                Toast.makeText(
                    requireContext(), "Camera permission denied", Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST_CODE) {
                val thumbnail: Bitmap? = data?.extras?.get("data") as Bitmap?
                rekamImg.setImageBitmap(thumbnail)
                if (thumbnail != null) {
                    saveToGallery(thumbnail)
                }
            }
        }
    }
    private fun saveToGallery(thumbnail: Bitmap){
        val storageDir: File = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES)
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss",
            Locale.getDefault()).format(Date())
        val fileName = "IMG_$timeStamp.jpg"

        val imageFile = File(storageDir, fileName)

        try {
            val outputStream = FileOutputStream(imageFile)
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()

            val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            mediaScanIntent.setData(Uri.fromFile(imageFile))

            MediaScannerConnection.scanFile(
                requireContext(),
                arrayOf(imageFile.absolutePath),
                null, null
            )
            Toast.makeText(requireContext(), "Image saved successfully",
                Toast.LENGTH_SHORT).show()

        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CAMERA_REQUEST_CODE = 2
    }

}