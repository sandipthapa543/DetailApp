package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.detailapp.R;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.ProfileDetails;

public class AdapterProfile extends RecyclerView.Adapter<AdapterProfile.ContactsViewHolder> {

    Context context;
    List<ProfileDetails>profileDetailsList;

    public AdapterProfile(Context context, List<ProfileDetails>profileDetailsList ) {
        this.context = context;
       this.profileDetailsList=profileDetailsList;
    }


    @NonNull
    @Override
    public AdapterProfile.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_detail, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProfile.ContactsViewHolder holder, int position) {
        final ProfileDetails profileDetails= profileDetailsList.get(position);
        holder.imageview.setImageResource(profileDetails.getImg());
        holder.name.setText(profileDetails.getNames());
        holder.gender.setText(profileDetails.getGender());
        holder.age.setText(profileDetails.getAges());

    }

    @Override
    public int getItemCount() {
        return profileDetailsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {

     private CircleImageView imageview;
     private TextView name,age,gender;


        public ContactsViewHolder(View view) {
            super(view);
            imageview=view.findViewById(R.id.imageview);
            name=view.findViewById(R.id.name);
            age=view.findViewById(R.id.age);
           gender= view.findViewById(R.id.gender);
        }
    }
}

