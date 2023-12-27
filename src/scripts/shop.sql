use shop;

create table customer (
    email varchar(50) not null primary key,
    nama varchar(30) not null,
    saldo int not null,
    nomor_telepon varchar(12) not null,
    password varchar(20) not null,
    image_path varchar(50) not null
);

create table seller (
    email varchar(50) not null primary key,
    nama varchar(30) not null,
    nama_toko varchar(30) not null,
    saldo int not null,
    nomor_telepon varchar(12) not null,
    password varchar(20) not null,
    image_path varchar(50) not null
);

create table produk (
    id_barang int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nama varchar(30) NOT NULL, 
    harga int NOT NULL,
    stok int NOT NULL, 
    kategori varchar(10) NOT NULL, 
    deskripsi varchar(50), 
    image_path varchar(50) NOT NULL, 

    -- Not the best practice making it a primary key, but whatev
    penjual varchar(50), 
    FOREIGN KEY(penjual) REFERENCES seller(email)
);