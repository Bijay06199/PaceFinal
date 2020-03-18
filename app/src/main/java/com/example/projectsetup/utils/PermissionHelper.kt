package com.example.projectsetup.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.projectsetup.R
import com.example.projectsetup.utils.extentions.showToast
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * A Helper class to request permissions.
 * @param activity  calling activity
 * @param permissions a string array of required permissions
 */

class PermissionHelper(private val activity: Activity, private val permissions: Array<String>) {

    fun checkAndRequestPermissions() {
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        Log.d(TAG, permissions.contentToString())
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    activity,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                listPermissionsNeeded.add(permission)
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(
                activity,
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
        }
    }

    /**
     * Call this function from onRequestPermissionsResult() method of calling activity
     */

//    fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        when (requestCode) {
//            REQUEST_ID_MULTIPLE_PERMISSIONS -> {
//                val perms: MutableMap<String, Int> = HashMap()
//                for (permission in permissions) {
//                    perms[permission] = PackageManager.PERMISSION_GRANTED
//                }
//                if (grantResults.size > 0) {
//                    var i = 0
//                    while (i < permissions.size) {
//                        perms[permissions[i]] = grantResults[i]
//                        i++
//                    }
//                    var allPermissionsGranted = true
//                    for (permission1 in permissions) {
//                        allPermissionsGranted =
//                            allPermissionsGranted && perms[permission1] == PackageManager.PERMISSION_GRANTED
//                    }
//                    if (allPermissionsGranted) {
//                        Log.d(
//                            PermissionHelper::class.java.simpleName,
//                            "onRequestPermissionsResult: all permissions granted"
//                        )
//                    } else {
////                        val message = activity.getString(R.string.the_app_has_not_been_granted)
////                        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
////                        builder.setTitle(R.string.permissions_required)
////                            .setMessage(message)
////                            .setCancelable(false)
////                            .setPositiveButton(
////                                activity.getString(R.string.ok)
////                            ) { dialog, _ ->
////                                checkRationale()
////                                dialog.dismiss()
////                                dialog.cancel()
////                            }
////                        val alert: AlertDialog = builder.create()
////                        alert.show()
//                        activity.showToast(activity.getString(R.string.the_app_has_not_been_granted))
//                    }
//                }
//            }
//        }
//    }

    /**
     * Gets whether you should show UI with rationale for requesting a permission.
     */

    private fun checkRationale() {
        if (
            ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                Manifest.permission.CAMERA
            ) ||
            ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) || ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            checkAndRequestPermissions()
        } else {
            Toast.makeText(
                activity,
                "Please enable permissions from application settings",
                Toast.LENGTH_LONG
            )
                .show()
            val intent =
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.parse("package:" + activity.packageName)
            activity.startActivityForResult(intent, RESULT_ACTIVITY_CODE)
        }
    }

    /**
     *  @return If all the permissions requested are granted or not
     */

    val isAllPermissionAvailable: Boolean
        get() {
            var i = 0
            val permissionsLength = permissions.size
            while (i < permissionsLength) {
                val permission = permissions[i]
                val result = ContextCompat.checkSelfPermission(activity, permission)
                if (result != PackageManager.PERMISSION_GRANTED) return false
                i++
            }
            return true
        }

    /**
     * Call this method from onActivityResult() method of the calling activity
     */

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RESULT_ACTIVITY_CODE) {
            if (!isAllPermissionAvailable) {
                checkAndRequestPermissions()
            }
        }
    }

    companion object {
        const val TAG = "PermissionsHelper"
        const val RESULT_ACTIVITY_CODE = 123
        private const val REQUEST_ID_MULTIPLE_PERMISSIONS = 100 // any code you want.
    }

}