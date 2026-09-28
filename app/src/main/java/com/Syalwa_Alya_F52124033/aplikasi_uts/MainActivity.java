package com.Syalwa_Alya_F52124033.aplikasi_uts;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts;
    private ChanelAdapter adapter;
    private List<ChanelProduct> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // System bar padding
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        initViews();
        initData();
        setupAdapterAndList();
    }

    private void initViews() {
        listViewProducts = findViewById(R.id.listViewProducts);
    }

    private void initData() {
        productList = new ArrayList<>();

        productList.add(new ChanelProduct(
                1,
                "N°5 Eau de Parfum",
                "Classic Floral Aldehyde",
                "Parfum",
                "Rp 2.850.000",
                "Wewangian legendaris yang abadi dari CHANEL.",
                "100 ml",
                4.9,
                1280,
                R.drawable.parfum1
        ));

        productList.add(new ChanelProduct(
                2,
                "Coco Mademoiselle",
                "Sensual Amber Floral",
                "Parfum",
                "Rp 2.450.000",
                "Wewangian oriental dengan aroma jeruk segar dan mawar.",
                "100 ml",
                4.8,
                950,
                R.drawable.parfum2
        ));

        productList.add(new ChanelProduct(
                3,
                "Rouge Allure Velvet",
                "Luminous Matte Lip Colour",
                "Makeup",
                "Rp 750.000",
                "Lipstik matte selembut beludru dengan warna intens.",
                "3.5 g",
                4.7,
                620,
                R.drawable.lipvelvet
        ));

        productList.add(new ChanelProduct(
                4,
                "Classic Flap Bag",
                "Quilted Lambskin Gold Chain",
                "Tas",
                "Rp 165.000.000",
                "Tas ikonik CHANEL berbahan kulit domba dengan rantai emas.",
                "Medium 25.5 cm",
                5.0,
                310,
                R.drawable.bag1
        ));

        productList.add(new ChanelProduct(
                5,
                "Chance Eau Tendre",
                "Delicate Fruity-Floral",
                "Parfum",
                "Rp 2.300.000",
                "Keharuman lembut nan romantis dengan grapefruit dan melati.",
                "100 ml",
                4.8,
                810,
                R.drawable.parfum3

        ));

        productList.add(new ChanelProduct(
                6,
                "Les Beiges Water-Fresh Tint",
                "Bare-Skin Effect Foundation",
                "Makeup",
                "Rp 1.150.000",
                "Alas bedak ringan berteknologi mikro-droplet.",
                "30 ml",
                4.8,
                430,
                R.drawable.tint
        ));

        productList.add(new ChanelProduct(
                7,
                "J12 Ceramic Watch 33mm",
                "Highly Resistant Black Ceramic",
                "Jam & Perhiasan",
                "Rp 105.000.000",
                "Jam tangan keramik hitam mewah dengan presisi otomatis.",
                "33 mm",
                4.9,
                145,
                R.drawable.jam
        ));

        productList.add(new ChanelProduct(
                8,
                "Boy Chanel Handbag",
                "Calfskin & Antique Gold",
                "Tas",
                "Rp 115.000.000",
                "Desain modern dengan pengunci khas Boy Chanel.",
                "Medium 25 cm",
                4.9,
                215,
                R.drawable.bag2
        ));

        productList.add(new ChanelProduct(
                9,
                "Sublimage La Crème",
                "Ultimate Skin Revitalizing Cream",
                "Skincare",
                "Rp 6.800.000",
                "Krim regenerasi kulit premium CHANEL.",
                "50 g",
                4.9,
                180,
                R.drawable.skincare
        ));
    }

    private void setupAdapterAndList() {
        adapter = new ChanelAdapter(this, productList);

        listViewProducts.setAdapter(adapter);

        listViewProducts.setOnItemClickListener((parent, view, position, id) -> {
            ChanelProduct product = adapter.getItem(position);
            if (product != null) {
                Toast.makeText(MainActivity.this, 
                        "Anda memilih: " + product.getName() + " (" + product.getPrice() + ")", 
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
