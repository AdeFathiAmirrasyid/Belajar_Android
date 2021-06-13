package com.insanie.myrecyclerview

object OnePieceData {

    private val onePieceNames = arrayOf(
        "Portgas D'Ace",
        "Boa Hancock",
        "Dracule Mihawk",
        "Charlotte katakuri",
        "Trafalgar D'Water Law",
        "Monkey D'Luffy",
        "Marco The Phoenix",
        "Nico Robbin",
        "Nefertari Vivi",
        "Akagami no Shanks"
    )

    private val onePieceDetails = arrayOf(
        """ Portgas D. Ace merupakan salah satu karakter serial manga dan anime One PIece yang mempunyai ciri khas tersendiri.
            | Ace memiliki kemampuan menciptakan dan mengendalikan api karena memakan buah Mera mera no mi (elemen api),
            |  buah devil tipe logia yang memberikan Ace kekuatan yang luar biasa.""".trimMargin(),
        """ Boa Hancock adalah Satu-satunya wanita dari semua anggota Shichibukai. 
            |Saudara tertua dari tiga bersaudari “Gorgon”. Pemimpin Kelompok Bajak Laut Kuja, 
            |yang semua anggotanya wanita. Kecantikannya adalah kunci untuk mengalahkan lawannya. 
            |Pemakan buah iblis Mero Mero yang membuat dirinya memiliki kemampuan untuk membuat seseorang menjadi batu 
            |dengan syarat seseorang itu harus tertarik atau jatuh cinta padanya. Dia tidak mau gelar Shichibukai-nya 
            |dicabut walaupun dia membenci Pemerintah Dunia. Sifat Boa sangat sombong dan suka memandang rendah orang lain 
            |serta sangat manja.""".trimMargin(),
        """ Dracule Mihawk atau biasa juga disebut sebagai Mihawk si mata elang, adalah ahli pedang terkuat di dunia One Piece
            | dan merupakan sosok legendaris yang sangat penting di serinya. Mihawk sendiri dulu merupakan bagian 
            | dari Shichibukai atau tujuh bajak laut penguasa laut yang bekerja sama dengan Pemerintah Dunia. Namun,
            |  dengan sistem Shichibukai yang telah dibubarkan, sekarang dia tidak lagi menjadi bagian dari kelompok tersebut.
            |  """.trimMargin(),
        """ Katakuri adalah seorang pria yang sangat tinggi, besar, dan berotot dengan rambut crimson pendek yang runcing dan 
            |dua bekas luka simetris di kedua sisi wajahnya. Dia berdiri di hampir tiga kali ketinggian Luffy, 
            |dan sedikit lebih tinggi daripada adik triplet yang lebih muda, Daifuku dan Oven, yang sangat tinggi. 
            |Dia memiliki kaki yang panjang, dengan pahanya sama panjangnya dengan kaki bawahnya. Mulutnya, yang biasanya ditutupi, 
            |mengandung gigi tajam seperti belel yang sangat pelikan dan mampu meluas ke ukuran yang sangat besar.""".trimMargin(),
        """ Berasal dari NORTH BLUE. tersebutlah seorang bocah yang dari kecil hidup bahagia di kota putih , 
            |dengan lingkungan keluarga serba berpendidikan didunia medis, itu lah keluarga nya , orang tua law ini adalah 
            |dokter pintar dinegara nya, kehidupan awal law yang disayang kedua ortu nya dan
            | mempunyai 1 adik perempuan awal nya serba mewah dan serba bahagia, tapi saat bencana penyakit 
            | amber lead menyerang negara mereka , law mulai diserang kenyataan pahit luar biasa, singkat 
            | cerita di north blue tersebar sebuah cerita dimana bangsawan di white town negara FLEVANCE.
            | terkena wabah penyakit amber lead yang dikatakan pemerintah""".trimMargin(),
        """ Luffy adalah seorang pria muda yang terkenal karena topi jerami khasnya (dari mana ia mendapat julukan 
            |"Topi Jerami Luffy"), yang dipinjamkan kepadanya ketika ia masih muda oleh kapten bajak laut legendaris,
            | "Rambut Merah" Shanks, yang pada gilirannya menerimanya dari Gol D. Roger. Dia memakai celana pendek biru
            |  dengan manset, sandal, dan rompi merah tanpa lengan. """.trimMargin(),
        """ Marco si Burung Phoenix adalah mantan Komandan Divisi ke-1 Bajak Laut Shirohige. 
            |Dia diberi julukan untuk kemampuan Buah Iblis-nya untuk berubah menjadi phoenix. ... 
            |Setelah Perang Balas Dendam, Marco bekerja sebagai dokter di desa asal Shirohige, Sphinx, 
            |dan untuk Bajak Laut Shirohige.""".trimMargin(),
        """Robin adalah anak yatim piatu yang lahir di Ohara, ibunya, Nico Olvia pergi untuk penelitian ketika dia masih kecil,
            | ekspedisi ini adalah untuk menyelesaikan pekerjaan mendiang suaminya, dan karena itu adalah kewajibannya untuk 
            | ambil bagian. Dia dan putrinya dipisahkan sangat awal - terlalu dini hingga Robin tidak bisa mengingat 
            | wajah ibunya. Robin sangat merindukan kasih sayang karena selama ini sampai umurnya 8 tahun dia dirawat 
            | semena-semena oleh bibinya, Roji.""".trimMargin(),
        """Vivi memiliki rambut panjang bergelombang berwarna biru laut. Dia paling sering terlihat rambutnya dikuncir 
            |ekor kuda. Dia memiliki tubuh yang ramping, Kaki serta lengan yang panjang dan payudara yang menonjol. 
            |Dia selalu memakai pakaian yang agak tertutup dibandingkan wanita-wanita yang ada di Kru Bajak laut Topi Jerami 
            |(Nami dan Nico Robin).""".trimMargin(),
        """Shanks adalah pria yang relatif tinggi (hanya di bawah dua meter),[6] bertubuh kekar, berkulit sawo matang, 
            |dan berada di puncak masa remajanya.[8] Di antara Yonko dulu dan sekarang, dia menonjol sebagai yang terkecil, 
            |berukuran paling jauh sejauh ini, yang lain memiliki berbagai 
            |tingkat proporsi yang tidak manusiawi.""".trimMargin()
    )

    private val onePieceImages = intArrayOf(
        R.drawable.ace,
        R.drawable.boa,
        R.drawable.dracule_mihawk,
        R.drawable.katakuri,
        R.drawable.law,
        R.drawable.luffy,
        R.drawable.marko,
        R.drawable.robbin,
        R.drawable.vivi,
        R.drawable.shank,
    )

    val listData: ArrayList<OnePiece>
        get() {
            val list = arrayListOf<OnePiece>()
            for (posision in onePieceNames.indices) {
                val onePiece = OnePiece()
                onePiece.data_name = onePieceNames[posision]
                onePiece.data_detail = onePieceDetails[posision]
                onePiece.data_image = onePieceImages[posision]
                list.add(onePiece)
            }
            return list
        }
}