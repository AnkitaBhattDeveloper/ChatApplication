package com.example.chatapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.chatapplication.adapter.MessageAdapter;
import com.example.chatapplication.databinding.ActivityMessageBinding;
import com.example.chatapplication.model.ChatType;
import com.example.chatapplication.model.MessageModel;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {
    ActivityMessageBinding binding;
    Context context;
    ArrayList<MessageModel> msgList = new ArrayList<>();
    String etMsg;
    ActivityResultLauncher<Intent> launcher;
    String type;
    Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    fileUri = data.getData();
                    Log.e("TAG", "onActivityResult: data " + data);
                    binding.ivImage.setImageURI(fileUri);

                }
            }
        });


        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etMsg = binding.etSenderMsg.getText().toString();
                if (etMsg.equals(""))
                    Toast.makeText(context, "Please type Something", Toast.LENGTH_SHORT).show();
                else
                    getMessageAdapter(etMsg, String.valueOf(ChatType.Text),null);
                binding.etSenderMsg.setText("");
            }
        });


        binding.document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);
                getMessageAdapter("", String.valueOf(ChatType.Image),fileUri);
                Log.e("TAG", "onClick: intent");
            }
        });

    }


    public void getMessageAdapter(String msg, String type,Uri image) {
        MessageAdapter messageAdapter = new MessageAdapter(context, msgList, "image");
        binding.rvSenderMsgs.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        msgList.add(new MessageModel("abc", msg, image, ChatType.Image));
        binding.rvSenderMsgs.setAdapter(messageAdapter);
    }

}