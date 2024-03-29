package com.example.patriotconnect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnHousingFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HousingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HousingFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btn_pick) Button btn_pick;

    private OnHousingFragmentInteractionListener mListener;
    private View mView;

    public HousingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HousingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HousingFragment newInstance(String param1, String param2) {
        HousingFragment fragment = new HousingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_housing, container, false);

        Button btn_pick = (Button) mView.findViewById(R.id.btn_pick);
        btn_pick.setOnClickListener(this);

        // Inflate the layout for this fragment
        return mView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onHousingInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHousingFragmentInteractionListener) {
            mListener = (OnHousingFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHousingFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pick:
                mListener.onHousingInteraction();
                break;

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHousingFragmentInteractionListener {
        // TODO: Update argument type and name
        void onHousingInteraction();
    }
}
