package com.denis.cobapermission;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int SHOW_CONTACT = 1;
    private final int PERMISSION_REQ_CONTACT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = {Manifest.permission.READ_CONTACTS};
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {
            for(String permission: permissions) {
                //cek apakah permission sudah pernah ditanyakan atau belum
                if(ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQ_CONTACT);
                }
            }
        }
    }

    public void ShowContact(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, SHOW_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SHOW_CONTACT) {
            if(resultCode == RESULT_OK) {
                final String[] projection = new String[] {
                        ContactsContract.Contacts.DISPLAY_NAME
                };
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                        projection, null, null, null);
                if(cursor != null) {
                    if(cursor.moveToFirst()) {
                        String name = cursor.getString(
                                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "User canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}