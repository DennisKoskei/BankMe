package com.students.bankme;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class WithdrawDialog extends AppCompatDialogFragment {
    int amountToWithdraw;
    private EditText enteredWithdrawAmount;
    private WithdrawDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_withdraw_dialog, null);

        builder.setView(view);
        builder.setTitle("Withdraw Amount");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                amountToWithdraw = Integer.parseInt(enteredWithdrawAmount.getText().toString());
                listener.applyTexts2(amountToWithdraw);
            }
        });
        enteredWithdrawAmount = view.findViewById(R.id.enteredWithdrawAmount);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (WithdrawDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DepositDialogListener");
        }
    }
    public interface WithdrawDialogListener{
        void applyTexts2( int enteredWithdrawAmount);
    }
}
