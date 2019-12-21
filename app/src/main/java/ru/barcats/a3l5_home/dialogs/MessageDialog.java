package ru.barcats.a3l5_home.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import ru.barcats.a3l5_home.R;

public class MessageDialog extends DialogFragment {

    private static  final String MESSAGE = "MESSAGE";

    public static MessageDialog newInstance(String message){
        Bundle args = new Bundle();
        args.putString(MESSAGE, message);
        MessageDialog dialog = new MessageDialog();
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = Objects.requireNonNull(getActivity()).getLayoutInflater().
                inflate(R.layout.dialog_message, null);

        builder.setView(view);

        TextView textViewMessage = view.findViewById(R.id.textViewMessage);
        textViewMessage.setText(Objects.requireNonNull(getArguments()).getString(MESSAGE));

        Button buttonOk = view.findViewById(R.id.buttonOkMessage);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }
}
