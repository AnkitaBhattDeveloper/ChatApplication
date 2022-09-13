package com.example.chatapplication.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.chatapplication.adapter.ChatAdapter;
import com.example.chatapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Context context;
    ArrayList<String> chatList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        getAdapter();
    }

    public void getAdapter() {
        ChatAdapter chatAdapter = new ChatAdapter(context, chatList);
        binding.chatsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        chatList.add("");
        chatList.add("");
        chatList.add("");
        chatList.add("");
        binding.chatsRecyclerView.setAdapter(chatAdapter);

    }

}