package com.android.store;

import java.util.ArrayList;
import java.util.List;

public class Productos {

    public static List<ProductoBean> getProductosPorCategoria(String s) {

        List<ProductoBean> list = new ArrayList<>();

        if(s.equals("delantales")){

            list.add(new ProductoBean("Delantal 1",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Delantal 2",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Delantal 3",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Delantal 4",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Delantal 5",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Delantal 6",R.drawable.ic_launcher_background,1500));

            return list;
        }

        if(s.equals("manteleria")){

            list.add(new ProductoBean("Manteleria 1",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Manteleria 2",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Manteleria 3",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Manteleria 4",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Manteleria 5",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Manteleria 6",R.drawable.ic_launcher_background,1500));

            return list;
        }

        if(s.equals("individual")){

            list.add(new ProductoBean("Individual 1",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Individual 2",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Individual 3",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Individual 4",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Individual 5",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Individual 6",R.drawable.ic_launcher_background,1500));

            return list;
        }
        if(s.equals("tapiceria")){

            list.add(new ProductoBean("Tapiceria Silla 1",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Tapiceria Silla 2",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Tapiceria Silla 3",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Tapiceria Silla 4",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Tapiceria Silla 5",R.drawable.ic_launcher_background,1500));
            list.add(new ProductoBean("Tapiceria Silla 6",R.drawable.ic_launcher_background,1500));

            return list;
        }


        return null;
    }
}
