package com.example.nju.bet2win;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by leo on 6/28/2017.
 */

public class Viparchive extends Activity {
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mStorageRef = FirebaseStorage.getInstance().getReference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viparchive);


        /*

File localFile = File.createTempFile("images", "jpg");
riversRef.getFile(localFile)
    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
            // Successfully downloaded data to local file
            // ...
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception exception) {
            // Handle failed download
            // ...
        }
    });
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.varchive, menu);
        return true;
    }

}
