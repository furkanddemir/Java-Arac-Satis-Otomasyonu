-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 26 Ara 2023, 15:50:43
-- Sunucu sürümü: 10.4.28-MariaDB
-- PHP Sürümü: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `galeri`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ilanlar`
--

CREATE TABLE `ilanlar` (
  `ID` int(11) NOT NULL,
  `Baslik` varchar(250) NOT NULL,
  `Marka` varchar(50) DEFAULT NULL,
  `Model` varchar(50) DEFAULT NULL,
  `Tip` varchar(50) DEFAULT NULL,
  `MotorHacmi` varchar(50) DEFAULT NULL,
  `YakitTuru` varchar(50) DEFAULT NULL,
  `Vites` varchar(50) NOT NULL,
  `Km` varchar(50) DEFAULT NULL,
  `Yil` int(4) DEFAULT NULL,
  `Renk` varchar(50) DEFAULT NULL,
  `Fiyat` varchar(50) DEFAULT NULL,
  `Iletisim` varchar(50) NOT NULL,
  `Adres` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `ilanlar`
--

INSERT INTO `ilanlar` (`ID`, `Baslik`, `Marka`, `Model`, `Tip`, `MotorHacmi`, `YakitTuru`, `Vites`, `Km`, `Yil`, `Renk`, `Fiyat`, `Iletisim`, `Adres`) VALUES
(65, '2018 ÇIKIŞ EGEA 1.3 DİZEL HATASIZ DEĞİŞENSİZ EMSALSİZ', 'Fiat ', 'Egea ', 'Sedan', '1.3', 'Dizel', 'Manuel', '203.000', 2017, 'Beyaz', '499.750 TL', '0532 145 8745', 'İzmir / Bornova / Egemenlik Mah.'),
(66, 'SAHİBİNDEN 2014 CIKISLI HATASIZ BOYASIZ FOCUS', 'Ford ', 'Focus ', 'Hatchback ', '1.6', 'Dizel', 'Manuel', '161.000 ', 2013, 'Beyaz', '669.000 TL', '0551 758 9656', 'Mersin / Mezitli / Davultepe Mah.'),
(67, 'AUDİ A5 COUPE 40 TDİ QUATTRO S-LİNE', 'Audi ', 'A5', 'Coupe', '1.9', 'Dizel', 'Otomatik', '57.500', 2020, 'Beyaz', '2.549.000 TL', '0530 456 9620', 'İstanbul / Beylikdüzü / Cumhuriyet Mah.'),
(68, 'ÖZEL ÜRETİM BMW 7 SERİSİ ', 'BMW ', '520i', 'Sedan', '1.6', 'Benzin', 'Otomatik', '96.000', 2020, 'Mavi', '2.525.000 TL', '0537 501 6215', 'İstanbul / Ümraniye / Çakmak Mh.'),
(69, 'MERCEDES C180 AMG/ 19\'JANT/ CAM TAVAN/ ELEKTRİKLİ BAGAJ/HATASIZ', 'Mercedes-Benz', 'C 180 AMG ', 'Sedan', '1.6', 'Benzin', 'Otomatik', '146.000', 2015, 'Beyaz', '1.407.000 TL', '0543 205 4253', 'İstanbul / Ümraniye / Tatlısu Mh.'),
(70, '2015 PORSCHE PANAMERA GTS \'\'FULL LED, ADAPTİF ŞASİ\'', 'Porsche ', 'Panamera GTS  ', ' Hatchback', '4.0', 'Benzin', 'Otomatik', '50.172', 2015, 'Füme', '7.490.000 TL', '0531 254 7447', 'İstanbul / Beşiktaş / Kültür Mh.'),
(71, 'SAHİSİNDEN EN DOLU VOLVO S90 ', 'Volvo ', 'S90 ', 'Sedan', '2.0', 'Dizel', 'Otomatik', '129.000', 2018, 'Siyah', '2.150.000 TL', '0533 210 5465', 'Ankara / Etimesgut '),
(72, 'İLK SAHİSİNDEN ÖZEL SERİ BMW ', 'BMW ', ' i7 xDrive60 ', 'Sedan', '-', 'Elektrik', 'Otomatik', '6.050', 2023, 'Siyah', '9.080.000 TL', '0530 581 2368', 'İstanbul / Üsküdar / Altunizade Mh.'),
(73, 'SAHİSİNDEN SATILIK 1.6 TDI PASSAT', 'Volkswagen ', 'Passat ', 'Sedan', '1.6', 'Dizel', 'Otomatik', '250.000 ', 2014, 'Siyah', '850.000 TL', '0533 511 0208', 'Antalya / Kepez / Göçerler Mh.'),
(74, 'SAHİSİNDEN 2020 MODEL RENAULT MEGANE', 'Renault ', 'Megane ', 'Sedan', '1.5', 'Dizel ', 'Otomatik', '163.000', 2020, 'Beyaz', '789.000 TL', '0533 499 1192', 'Ankara / Çankaya / Çayyolu Mh.'),
(75, 'BAYİSİNDEN AUDİ A7 40 TDI QUATTRO S-LINE', 'Audi ', 'A7 ', ' Hatchback', '4.0', 'Dizel', 'Otomatik', '78.000', 2019, 'Gri', '4.380.000 TL', '0532 924 3522', 'İstanbul / Sancaktepe / Eyüp Sultan Mh.'),
(76, 'İLK SAHİSİNDEN SIKINTISIZ 93 TOFAŞ', 'Tofaş ', 'Şahin ', 'Sedan', '1.6 ', 'Benzin & LPG', 'Manuel', '200.000', 1993, 'Kırmızı', '143.500 TL', '0545 224 1839', 'Ankara / Keçiören / Bademlik Mah.'),
(77, '2023 TOGG T10X V2 UZUN MENZİL, RWD, CAM TAVAN+MERİDİEN', 'TOGG ', 'T10X V2', 'SUV', '-', 'Elektrik', 'Otomatik', '6.001', 2023, 'Siyah', '1.800.000 TL', '0534 963 4598', 'Bursa / Nilüfer / Işıktepe Mh.'),
(78, '34 BİN\'DE 5008 CAM TVN+KTLANR AYNA+KLTK ISTMA+HAYALET HATASIZ', 'Peugeot ', '5008 ', 'SUV', '1.5', 'Dizel', 'Otomatik', '34.000', 2021, 'Lacivert', '1.590.000 TL', '0554 651 5486', 'İstanbul / Bahçelievler / Yenibosna');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanicilar`
--

CREATE TABLE `kullanicilar` (
  `id` int(11) NOT NULL,
  `kullanici_adi` varchar(50) NOT NULL,
  `sifre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kullanicilar`
--

INSERT INTO `kullanicilar` (`id`, `kullanici_adi`, `sifre`) VALUES
(8, 'Furkan', '3438');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `ilanlar`
--
ALTER TABLE `ilanlar`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `kullanicilar`
--
ALTER TABLE `kullanicilar`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `ilanlar`
--
ALTER TABLE `ilanlar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- Tablo için AUTO_INCREMENT değeri `kullanicilar`
--
ALTER TABLE `kullanicilar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
