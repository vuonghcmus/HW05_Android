package com.example.hw05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetailStudent extends Fragment {

    private View view;
    private TextView txtID;
    private TextView txtDiem;
    private TextView txtHoTen;
    private TextView txtLop;
    private Button btnFirst;
    private Button btnPrevious;
    private Button btnNext;
    private Button btnLast;
    private ListView listView;
    private int index; // index cua item trong list view vua moi dc click

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_detail_student, container, false);

        txtID = (TextView) view.findViewById(R.id.txtID);
        txtDiem = (TextView) view.findViewById(R.id.txtDiem);
        txtHoTen = (TextView) view.findViewById(R.id.txtHoTen);
        txtLop = (TextView) view.findViewById(R.id.txtLop);

        btnFirst = (Button) view.findViewById(R.id.btnFirst);
        btnLast = (Button) view.findViewById(R.id.btnLast);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnPrevious = (Button) view.findViewById(R.id.btnPrevious);

        listView = FragmentListStudent.listView;
        index = FragmentListStudent.index;

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 0;
                setDataStudent(index);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == listView.getCount() - 1){
                    Toast.makeText(getActivity(), "Đã đến cuối danh sách", Toast.LENGTH_SHORT).show();
                } else {
                    index++;
                    setDataStudent(index);
                }
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = listView.getCount() - 1;
                setDataStudent(index);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0){
                    Toast.makeText(getActivity(), "Đã về đầu danh sách", Toast.LENGTH_SHORT).show();
                } else {
                    index--;
                    setDataStudent(index);
                }
            }
        });

        return view;
    }

    // set data cua sinh vien tai vi tri index trong list view
    public void setDataStudent(int index) {
        Student student = (Student) listView.getItemAtPosition(index);
        txtID.setText(student.getID());
        txtHoTen.setText("Họ tên: " + student.getName());
        txtLop.setText("Lớp: 19/3");
        txtDiem.setText("Điểm trung bình: 8.5");
    }

    public void receivedDataFromFragment(Student student) {
        txtID.setText(student.getID());
        txtHoTen.setText("Họ tên: " + student.getName());
        txtLop.setText("Lớp: 19/3");
        txtDiem.setText("Điểm trung bình: 8.5");
    }
}
