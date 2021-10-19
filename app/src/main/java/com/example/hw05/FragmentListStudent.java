package com.example.hw05;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentListStudent extends Fragment {
    public static ListView listView;
    public static int index; // index cua item vua moi  click
    private TextView txtMsg;
    private ArrayList<Student> studentList = new ArrayList<>();
    private View view;

    private ISendDataListener iSendDataListener;

    public interface ISendDataListener {
        void sendDataStudent(Student student);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_list_students, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        txtMsg = (TextView) view.findViewById(R.id.txtMsg);

        studentList.add(new Student("Ngọc Nguyên", "19120605", "avatar1"));
        studentList.add(new Student("Trọng Phước", "19120624", "avatar5"));
        studentList.add(new Student("Hồng Quân", "19120629", "avatar3"));
        studentList.add(new Student("Quốc Vương", "19120728", "avatar4"));
        studentList.add(new Student("Thảo Vy", "19120729", "avatar1"));

        CustomListAdapter customListAdapter = new CustomListAdapter(getActivity(), studentList);
//        txtMsg.setText("" + customListAdapter.s);
        listView.setAdapter(customListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                Object obj = listView.getItemAtPosition(i);
                Student student = (Student) obj;
                txtMsg.setText("ID: " + student.getID());
                iSendDataListener.sendDataStudent(student);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iSendDataListener = (ISendDataListener) getActivity();
    }
}