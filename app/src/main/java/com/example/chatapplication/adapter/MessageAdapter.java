package com.example.chatapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapplication.R;
import com.example.chatapplication.model.ChatType;
import com.example.chatapplication.model.MessageModel;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    ArrayList<MessageModel> messageList;
    Context context;
    private static final int SENDER_TEXT = 1;
    private static final int RECEIVER_TEXT = 2;
    private static final int SENDER_IMAGE = 3;
    private static final int RECEIVER_Image = 4;

    public MessageAdapter(Context context, ArrayList<MessageModel> messageList, String Type) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        if (messageList.get(position).getId().equals("abc")) {
            if (ChatType.Image.equals("image")) {
                return SENDER_IMAGE;
            }
            return SENDER_TEXT;
        } else
            return RECEIVER_TEXT;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SENDER_TEXT) {
            View view = LayoutInflater.from(context).inflate(R.layout.sender_text_layout, parent, false);
            return new SenderTextViewHolder(view);
        }

        if (viewType == SENDER_IMAGE) {
            View view = LayoutInflater.from(context).inflate(R.layout.sender_image_layout, parent, false);
            return new SenderImageViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiver_text_layout, parent, false);
            return new ReceiverTextViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //MessageModel messageModel = messageList.get(position);
        if (holder.getClass() == SenderTextViewHolder.class) {
            ((SenderTextViewHolder) holder).tvSenderMsg.setText(messageList.get(position).getMessage());
        }
        if (holder.getClass() == ReceiverTextViewHolder.class) {
            ((ReceiverTextViewHolder) holder).tvReceiverMsg.setText(messageList.get(position).getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class SenderTextViewHolder extends RecyclerView.ViewHolder {
        TextView tvSenderMsg;

        public SenderTextViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSenderMsg = itemView.findViewById(R.id.tvSenderMsg);

        }
    }

    class SenderImageViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSenderImage;

        public SenderImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSenderImage = itemView.findViewById(R.id.ivSenderImage);

        }

    }


    class ReceiverTextViewHolder extends RecyclerView.ViewHolder {
        TextView tvReceiverMsg;

        public ReceiverTextViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReceiverMsg = itemView.findViewById(R.id.tvReceiverMsg);

        }
    }
}
