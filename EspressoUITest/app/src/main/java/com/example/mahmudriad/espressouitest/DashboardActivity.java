package com.example.mahmudriad.espressouitest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    GridView gridView;
    String titles[] = { "Dashboard", "Retail Sale", "Whole Sale", "Due Receive", "Item Return", "Add Stock",
            "Company Items", "Suppliers", "Customers", "Accounts", "Reports", "Settings", "Users"};

    int icons[] = {R.drawable.dashboard, R.drawable.retail_sale, R.drawable.whole_sale,
            R.drawable.due_receive, R.drawable.return_item, R.drawable.add_stock,
            R.drawable.comp_items, R.drawable.supplier, R.drawable.customers,
            R.drawable.income, R.drawable.reports, R.drawable.category, R.drawable.users };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Place your code here

        implementClickEvent();

        gridView = (GridView) findViewById(R.id.gridView);

        GridAdapter adapter = new DashboardActivity.GridAdapter(DashboardActivity.this, icons, titles);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DashboardActivity.this, "Clicked at: + "+titles[i], Toast.LENGTH_SHORT).show();
            }
        });

    }




    public class GridAdapter extends BaseAdapter {

        private int icons[];
        private String titles[];

        private Context context;
        private LayoutInflater inflater;


        public GridAdapter(Context context, int icons[], String titles[]) {
            this.context = context;
            this.icons = icons;
            this.titles = titles;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int i) {
            return titles[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View gridView = getLayoutInflater().inflate(R.layout.dashboard_grid_layout, null);

            ImageView icon = (ImageView) gridView.findViewById(R.id.gridIcon);
            TextView title = (TextView) gridView.findViewById(R.id.gridTitle);

            icon.setImageResource(icons[i]);
            title.setText(titles[i]);

            return gridView;
        }
    }

    private void implementClickEvent() {

        // On Click On My Task Icon
        ImageView myTaskImage = (ImageView) this.findViewById(R.id.myTaskImage);
        myTaskImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "My Task Icon Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // On Click On Reload Icon
        ImageView reloadImage = (ImageView) this.findViewById(R.id.reloadImage);
        reloadImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Reload Icon Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // On Click On Settings Icon
        ImageView settingsImage = (ImageView) this.findViewById(R.id.settingsImage);
        settingsImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Settings Icon Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
