package com.insanie.wisata_indonesia

object WisataData {
    val list : ArrayList<Wisata>
    get(){
        val list : ArrayList<Wisata> = arrayListOf()

        list.add(Wisata(
                dataName = "Kawah Putih",
                dataDesc =  "Wisata Indonesia",
                dataImage = R.drawable.image1))

        list.add(Wisata(
            dataName = "Grand Canyon",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image2))

        list.add(Wisata(
            dataName = "Taman Nasional Komodo",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image3))

        list.add(Wisata(
            dataName = "Pink Beach Lombok",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image4))

        list.add(Wisata(
            dataName = "Pantai Hiu",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image5))
        list.add(Wisata(
            dataName = "Danau Plitvice",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image6))
        list.add(Wisata(
            dataName = "Pantai Ora",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image7))

        list.add(Wisata(
            dataName = "Kawah Putih",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image1))

        list.add(Wisata(
            dataName = "Grand Canyon",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image2))

        list.add(Wisata(
            dataName = "Taman Nasional Komodo",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image3))

        list.add(Wisata(
            dataName = "Pink Beach Lombok",
            dataDesc =  "Wisata Indonesia",
            dataImage = R.drawable.image4))




        return list
    }
}