package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class SQlite {
    
    private Connection con;
    private Statement st;
    
    public  void Baglanti() {
        try {
            String url = "jdbc:sqlite:test.db";
            con = DriverManager.getConnection(url);
            Statement tablo;
            tablo=con.createStatement();
            String sql = "CREATE TABLE if not exists OGRENCI " +
                            "(OGRNO INT PRIMARY KEY     NOT NULL," +
                            " OGRAD  CHAR(50)    NOT NULL, " + 
                            " OGRSOYAD   CHAR(50)     NOT NULL)"; 
            tablo.executeUpdate(sql);
            System.out.println("Veritabanı Oluşturma Başarılı");
            } 
        
        catch (SQLException e) {
            System.out.println(e.getNextException());
        }
    }
    
    
    
    public  void Listele(){
        try{
            Statement stmt=con.createStatement();  
            //ResultSet rs=stmt.executeQuery("select * from ogrenci"); 
            ResultSet rs2=stmt.executeQuery("select OGRNO from ogrenci where OGRNO>25");
            //while(rs.next())  
            //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            while(rs2.next())  
            System.out.println(rs2.getInt(1));
            
           }
        catch(Exception e){ 
            System.out.println(e);
        }
       }
    
    
    public void KayitEkle(){
        Scanner scan= new Scanner(System.in,"iso-8859-9");
        System.out.print("Yeni Öğrenci No     :");
        int yenino = scan.nextInt();
        System.out.print("Yeni Öğrenci Adı    :");
        String ad=scan.next();
        System.out.print("Yeni Öğrenci Soyadı :");
        String soyad=scan.next();
        
        try{
            Statement stmt=con.createStatement(); 
            String sorgu=String.format("insert into ogrenci values( %d, '%s','%s')", yenino,ad,soyad);
            int ekleme = stmt.executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
            }
        catch(Exception e){ 
            System.out.println(e);
            }
    }
    
    
    
    public  void Sil(){
        
        Scanner scan= new Scanner(System.in,"iso-8859-9");
        try{
            System.out.print("Öğrenci Numarasını Girin:");
            int eskino=scan.nextInt();  
            String sorgu=String.format("delete from ogrenci where ogrno=%d",eskino);
            Statement stmt=con.createStatement(); 
            int silindi = stmt.executeUpdate(sorgu);  
            System.out.println("Kayıtlar Silindi");
            }
        catch(Exception e){ 
                
                System.out.println(e);
            }
        }
    
    
    public  void Guncelle(){
        
        Scanner scan= new Scanner(System.in,"iso-8859-9");
        try{
            Listele();
            System.out.print("Öğrenci Numarasını Girin:");
            int eskino=scan.nextInt();
            System.out.print("Yeni Öğrenci No     :");
            int yenino = scan.nextInt();
            System.out.print("Yeni Öğrenci Adı    :");
            String ad=scan.next();
            System.out.print("Yeni Öğrenci Soyadı :");
            String soyad=scan.next();
            
            String sorgu=String.format("update ogrenci set ogrno=%d, ograd='%s',ogrsoyad='%s' where ogrno=%d ", yenino,ad,soyad,eskino) ;
            
            Statement stmt=con.createStatement(); 
            int guncelleme = stmt.executeUpdate(sorgu);  
            System.out.println("Kayıtlar Güncellendi");
        }catch(Exception e){ System.out.println(e);}
    }
     
    
     
     
     
    

    public static void main(String[] args) {
        
        SQlite data=new SQlite();
        data.Baglanti();
        //data.KayitEkle();
        //data.Listele();
        //data.Sil();
        data.Listele();
        data.Guncelle();
        
    }
    
}

/*                      SQL SORGULARI

SELECT SORGULARI
1.Öğrenci tablosundaki tüm kayıtları listeleyin.


select * from ogrenci


 

2.Öğrenci tablosundaki öğrencinin adını ve soyadını ve sınıfını listeleyin.


select ograd,ogrsoyad,sinif from ogrenci


 

3. Öğrenci tablosundaki cinsiyeti kız (K) olan kayıtları listeleyiniz.


 
select * from ogrenci where cinsiyet='K'
 
 

4.Öğrenciler tablosundaki sınıfların adını listeleyiniz.(Not her sınıf adı birkez gösterilsin.)


 
select distinct sinif from ogrenci
 
 

5.Öğrenci tablosundaki cinsiyeti Kız ve Sınıfı 10A olan öğrencileri listeleyiniz.


 
select * from ogrenci where cinsiyet='K' and sinif='10A'
 
 

6.Öğrenci tablosundaki 10A veya 10B sınıfındaki öğrencilerin adını, soyadını ve sınıfını listeleyiniz.



 
select ograd, ogrsoyad, sinif from ogrenci 
where sinif='10A' or sinif='10B'
 
 

7.Öğrenci tablosundaki öğrencinin adını, soyadını ve numarasını okul numarası olarak listeleyiniz. (as kullanım örneği)



 
select ograd,ogrsoyad,ogrno as 'okul numarası' from ogrenci
 
 

8. Öğrenci tablosundaki öğrencinin adını ve soyadını birleştirip, adsoyad olarak listeleyiniz. (as kullanım örneği)



 
select ograd+ogrsoyad as 'Ad Soyad' from ogrenci
 
 

9. Öğrenci tablosundaki Adı ‘A’ harfi ile başlayan öğrencileri listeleyiniz.



 
select * from ogrenci where ograd like 'A%'
 
 

10.kitap tablosundaki sayfa sayısı 50 ile 200 arasında olan kitapların adını ve sayfa sayısını listeleyiniz.



 
select * from kitap where sayfasayisi between 50 and 200
 
 

11. Öğrenci tablosunda adı Fidan, İsmail ve Leyla olan öğrencileri listeleyiniz.



 
select * from ogrenci where ograd in ('Fidan','İsmail','Leyla')
 
 

12. Öğrenci tablosundaki öğrencilerden adı A, D ve K ile başlayan öğrencileri listeleyiniz.



 
select * from ogrenci where ograd like '[ADK]%'
 
 

13. Öğrenci tablosundaki sınıfı 9A olan Erkekleri veya sınıfı 9B olan kızların adını, soyadını, sınıfını ve cinsiyetini listeleyiniz.



 
select ograd,ogrsoyad,sinif,cinsiyet from ogrenci 
where (sinif='9A' and cinsiyet='E') or (sinif='9B' and cinsiyet='K')
 
 

14. Sınıfı 9A veya BB olan erkekleri listeleyiniz.



 
select ograd,ogrsoyad,sinif,cinsiyet from ogrenci 
where (sinif='9A' or sinif='9B') and cinsiyet='E'
 
 

15.Öğrenci tablosunda doğum yılı 1989 olan öğrencileri listeleyiniz.(Not: veritabanında tarihler ay/gün/yıl şeklinde sorgulanır)



 
select * from ogrenci 
where dtarih between '01/01/1989' and '12/31/1989'
 
16.Öğrenci numarası 30 ile 50 arasında olan Kız öğrencileri listeleyiniz.



 
select * from ogrenci 
where ogrno between 30 and 70 and cinsiyet = 'K'
 
 

17.Öğrencileri adına göre sıralayınız.



 
select * from ogrenci order by ograd
 
 

18. Öğrencileri adına, adı aynı olanlarıda soyadlarına göre sıralayınız.



select * from ogrenci order by ograd,ogrsoyad
 
 

19. 10A sınıfındaki öğrencileri okul numarasına göre azalan olarak sıralayınız.



 
select * from ogrenci where sinif='10A' order by ogrno desc
 
 

20. Öğrenciler tablosundaki ilk 10 kaydı listeleyiniz.



 
select top 10 * from ogrenci
 
 

21. Öğrenciler tablosundaki ilk 10 kaydın ad, soyad ve doğum tarihi bilgilerini listeleyiniz.



 
select top 10 ograd,ogrsoyad,dtarih from ogrenci
 
 

22.Sayfa sayısı en fazla olan kitabı listeleyiniz.



 
select top 1 * from kitap order by sayfasayisi desc
 
 

23. Öğrenciler tablosundaki en genç öğrenciyi listeleyiniz.



 
select top 1 ograd,ogrsoyad,dtarih from ogrenci order by dtarih desc
 
 

24. 10A sınıfındaki en yaşlı öğrenciyi listeyin.



 
select top 1 ograd,ogrsoyad,dtarih from ogrenci 
where sinif='10A' order by dtarih
 
 

25. İkinci harfi N olan kitapları listeleyiniz.



 
select * from kitap 
where kitapadi like '_n%'
 
 

26. Öğrencileri sınıflarına göre gruplayarak listeleyin.



 
select * from ogrenci order by sinif
 
 

27.  Öğrencileri her sorgulamada sıralaması farklı olacak şekilde  rastgele listeleyin.



 
select * from ogrenci order by newid()
 
 

28. Rastgele bir öğrenci seçin



 
select top 1 * from ogrenci order by newid()
 
 

29. 10A sınıfından rastgele bir öğrencinin adını, soyadını, numarasını ve sınıfını getirin.



 
select top 1 ogrno,ograd,ogrsoyad,sinif from ogrenci
where sinif= '10A' 
order by newid()











INSERT INTO SORGULARI
30. Yazar tablosunu KEMAL UYUMAZ isimli yazarı ekleyin.


 
insert into yazar(yazarad,yazarsoyad) values('Kemal','UYUMAZ')
 
 

31. Biyografi türünü tür tablosuna ekleyiniz.


 
insert into tur values('Biyografi')
 
32. 10A sınıfı olan ÇAĞLAR ÜZÜMCÜ isimli erkek,  sınıfı 9B olan LEYLA ALAGÖZ isimli kız ve  sınıfı 11C olan Ayşe Bektaş isimli kız  öğrencileri tek sorguda ekleyin.


insert into ogrenci(ograd,ogrsoyad,sinif,cinsiyet)
values('Çağlar','Üzümcü','10A','E'),('Leyla','Alagöz','9B','K'),('Ayşe','Bektaş','11C','K')
 
 

33 Öğrenci tablosundaki rastgele bir öğrenciyi yazarlar tablosuna yazar olarak ekleyiniz.


 
insert into yazar(yazarad, yazarsoyad) 
select top 1 ograd,ogrsoyad from ogrenci
order by newid()
 
 

34.Öğrenci numarası 10 ile 30 arasındaki öğrencileri yazar olarak ekleyiniz.


 
insert into yazar(yazarad, yazarsoyad) 
select ograd,ogrsoyad from ogrenci where ogrno between 10 and 30
 
 

35. Nurettin Belek isimli yazarı ekleyip yazar numarasını yazdırınız.(Not: Otomatik arttırmada son arttırılan değer @@IDENTITY değişkeni içinde tutulur.)


 
insert into yazar(yazarad, yazarsoyad) 
values('Nurettin','Belek')
select @@IDENTITY










UPDATE SORGULARI
NOT:update sorgusunda dikkat edilmesi gereken en önemli husus şart kısmıdır. şart yazılmazsa güncelleme işlemine tüm kayıtlar dahil edilir.

 

36. 10B sınıfındaki öğrenci numarası 3 olan öğrenciyi 10C sınıfına geçirin.


update ogrenci set sinif='10C' where ogrno=3

--sorguyu görüntülemek için yazıldı
select * from ogrenci where ogrno=3

1
2
3
4
5
6
 
update ogrenci set sinif='10C' where ogrno=3
 
--sorguyu görüntülemek için yazıldı
select * from ogrenci where ogrno=3
 
 

37.  9A sınıfındaki tüm öğrencileri 10A sınıfına aktarın


update ogrenci set sinif='10A' where sinif='9A'

--sorguyu görüntülemek için yazıldı
select * from ogrenci where sinif='10A'

1
2
3
4
5
6
 
update ogrenci set sinif='10A' where sinif='9A'
 
--sorguyu görüntülemek için yazıldı
select * from ogrenci where sinif='10A'
 
 

38. Tüm öğrencilerin puanını 5 puan arttırın.


update ogrenci set puan=puan+5

--sorguyu görüntülemek için yazıldı
select * from ogrenci

1
2
3
4
5
6
 
update ogrenci set puan=puan+5
 
--sorguyu görüntülemek için yazıldı
select * from ogrenci
 
 

DELETE SORGULARI
NOT 1: DELETE sorgusunda dikkat edilmesi gereken en önemli husus şart kısmıdır. şart yazılmazsa silme işlemine tüm kayıtlar dahil edilir.

NOT 2: TRUNCATE TABLE komutu sorgu örneklerinin sonunda verilecektir.(Tabloyu boşaltmak için kullanılır. TRUNCATE TABLE TABLOADI)

39.  25 numaralı yazarı silin.


--Not: veritabanı fk ayarlarında delete,update cascade ayarlandığı için ilişkili tabloları otomatik olarak güncellenecek.
delete from yazar where yazarno=25

1
2
3
4
 
--Not: veritabanı fk ayarlarında delete,update cascade ayarlandığı için ilişkili tabloları otomatik olarak güncellenecek.
delete from yazar where yazarno=25










DELETE SORGULARI
NOT 1: DELETE sorgusunda dikkat edilmesi gereken en önemli husus şart kısmıdır. şart yazılmazsa silme işlemine tüm kayıtlar dahil edilir.

NOT 2: TRUNCATE TABLE komutu sorgu örneklerinin sonunda verilecektir.(Tabloyu boşaltmak için kullanılır. TRUNCATE TABLE TABLOADI)

39.  25 numaralı yazarı silin.


 
--Not: veritabanı fk ayarlarında delete,update cascade ayarlandığı için ilişkili tabloları otomatik olarak güncellenecek.
delete from yazar where yazarno=25
 



SELECT …… IS NULL Komutu
Select sorguları içinde değeri null olan kayıtları ararken alanadı=null olarak arama yapılamaz.  Null olan alanları aramak için is null ifadesi kullanılır.

40. Doğum tarihi null olan öğrencileri listeleyin. (insert sorgusu ile girilen 3 öğrenci listelenecektir)


 
select * from ogrenci where dtarih  is null

 









SQL JOIN ( INNER JOIN ) KULLANIMI
45. Öğrencinin adını, soyadını ve kitap aldığı tarihleri listeleyin.


select ograd,ogrsoyad,islem.atarih from ogrenci
join islem on islem.ogrno=ogrenci.ogrno

1
2
3
4
 
select ograd,ogrsoyad,islem.atarih from ogrenci
join islem on islem.ogrno=ogrenci.ogrno
 
 

46. Fıkra ve hikaye türündeki kitapların adını  ve türünü listeleyin.


select kitapadi,turadi from kitap
join tur on kitap.turno=tur.turno 
and tur.turadi in('Hikaye','Fıkra')

1
2
3
4
5
 
select kitapadi,turadi from kitap
join tur on kitap.turno=tur.turno 
and tur.turadi in('Hikaye','Fıkra')
 
yada


select kitapadi,turadi from kitap
join tur on kitap.turno=tur.turno 
where tur.turadi in('Hikaye','Fıkra')

1
2
3
4
5
 
select kitapadi,turadi from kitap
join tur on kitap.turno=tur.turno 
where tur.turadi in('Hikaye','Fıkra')
 
 

47. 10B veya 10C sınıfındaki öğrencilerin numarasını, adını, soyadını ve okuduğu kitapları, öğrenci adına göre  listeleyin.


select ogrenci.ogrno,ograd,ogrsoyad,sinif,kitapadi
from ogrenci
join islem on ogrenci.ogrno=islem.ogrno
join kitap on islem.kitapno=kitap.kitapno
where sinif='10B' or sinif='10C'
order by ogrenci.ograd

1
2
3
4
5
6
7
8
 
select ogrenci.ogrno,ograd,ogrsoyad,sinif,kitapadi
from ogrenci
join islem on ogrenci.ogrno=islem.ogrno
join kitap on islem.kitapno=kitap.kitapno
where sinif='10B' or sinif='10C'
order by ogrenci.ograd
 
 

SQL LEFT JOIN Kullanımı
 

48. Kitap alan öğrencinin adı, soyadı, kitap aldığı tarih listelensin. Kitap almayan öğrencilerinde listede görünsün.


select ograd,ogrsoyad,islem.islemno from ogrenci
left join islem on islem.ogrno=ogrenci.ogrno

1
2
3
4
 
select ograd,ogrsoyad,islem.islemno from ogrenci
left join islem on islem.ogrno=ogrenci.ogrno
 
 

49. Kitap almayan öğrencileri listeleyin.


select ograd,ogrsoyad,islem.atarih from ogrenci
left join islem on islem.ogrno=ogrenci.ogrno
where islem.atarih is null

1
2
3
4
5
 
select ograd,ogrsoyad,islem.atarih from ogrenci
left join islem on islem.ogrno=ogrenci.ogrno
where islem.atarih is null
 
 

50. Alınan kitapların kitap numarasını, adını ve kaç defa alındığını kitap numaralarına göre artan sırada listeleyiniz.


select kitap.kitapno, kitap.kitapadi,count(*) from islem
left join kitap
on kitap.kitapno=islem.kitapno
group by kitap.kitapadi,kitap.kitapno
order by kitap.kitapno

1
2
3
4
5
6
7
 
select kitap.kitapno, kitap.kitapadi,count(*) from islem
left join kitap
on kitap.kitapno=islem.kitapno
group by kitap.kitapadi,kitap.kitapno
order by kitap.kitapno
 
 

51. Alınan kitapların kitap numarasını, adını kaç defa alındığını (alınmayan kitapların yanında 0 olsun) listeleyin.


select kitap.kitapno, kitap.kitapadi,count(islem.islemno) as adet from kitap
left join islem on kitap.kitapno=islem.kitapno
group by kitap.kitapadi,kitap.kitapno,islem.kitapno
order by adet

1
2
3
4
5
6
 
select kitap.kitapno, kitap.kitapadi,count(islem.islemno) as adet from kitap
left join islem on kitap.kitapno=islem.kitapno
group by kitap.kitapadi,kitap.kitapno,islem.kitapno
order by adet
 
 

52. Öğrencilerin adı soyadı ve aldıkları kitabın adı listelensin.


Select * from ogrenci 
left join islem on islem.ogrno=ogrenci.ogrno 
left join kitap on islem.kitapno=kitap.kitapno

1
2
3
4
5
 
Select * from ogrenci 
left join islem on islem.ogrno=ogrenci.ogrno 
left join kitap on islem.kitapno=kitap.kitapno
 
SQL LEFT JOIN ve RIGHT JOIN Kullanımı
53.Her öğrencinin adı, soyadı, kitabın adı, yazarın adı soyad ve kitabın türünü ve kitabın alındığı tarihi listeleyiniz.  Kitap almayan öğrenciler de listede görünsün.


Select ograd,ogrsoyad yazarad,yazarsoyad,kitapadi,turadi from kitap 
join tur on tur.turno=kitap.turno
join yazar on kitap.turno=yazar.yazarno
join islem on kitap.kitapno=islem.kitapno
right join ogrenci on ogrenci.ogrno=islem.ogrno

1
2
3
4
5
6
7
 
Select ograd,ogrsoyad yazarad,yazarsoyad,kitapadi,turadi from kitap 
join tur on tur.turno=kitap.turno
join yazar on kitap.turno=yazar.yazarno
join islem on kitap.kitapno=islem.kitapno
right join ogrenci on ogrenci.ogrno=islem.ogrno
 
 

54.Her öğrencinin adı, soyadı, kitabın adı, yazarın adı soyad ve kitabın türünü ve kitabın alındığı tarihi listeleyiniz.  Kitap almayan öğrenciler de listede görünsün.( Farklı Çözüm)


Select ograd,ogrsoyad yazarad,yazarsoyad,kitapadi,turadi from islem 
join kitap on islem.kitapno=kitap.turno
right join ogrenci on ogrenci.ogrno=islem.ogrno
left join tur on kitap.turno=tur.turno
left join yazar on yazar.yazarno=kitap.yazarno

1
2
3
4
5
6
7
 
Select ograd,ogrsoyad yazarad,yazarsoyad,kitapadi,turadi from islem 
join kitap on islem.kitapno=kitap.turno
right join ogrenci on ogrenci.ogrno=islem.ogrno
left join tur on kitap.turno=tur.turno
left join yazar on yazar.yazarno=kitap.yazarno
 
 

55. 10A veya 10B sınıfındaki öğrencilerin adı soyadı ve okuduğu kitap sayısını getirin.


select sinif, ograd,ogrsoyad,count(islemno) from ogrenci
left join islem on islem.ogrno=ogrenci.ogrno
where sinif in ('10A','10B')
group by sinif,ograd,ogrsoyad
order by count(*)

1
2
3
4
5
6
7
 
select sinif, ograd,ogrsoyad,count(islemno) from ogrenci
left join islem on islem.ogrno=ogrenci.ogrno
where sinif in ('10A','10B')
group by sinif,ograd,ogrsoyad
order by count(*)
 
İÇ İÇE SELECT SORGULARI
56.En fazla sayfa sayılı kitabın bilgilerini listeleyiniz.

Yöntem 1


select top 1 * from kitap order by sayfasayisi desc --1

1
2
3
 
select top 1 * from kitap order by sayfasayisi desc --1
 
Yöntem 2( İç içe select ile)


select * from kitap where sayfasayisi in (select max(sayfasayisi) from kitap) --2

1
2
3
 
select * from kitap where sayfasayisi in (select max(sayfasayisi) from kitap) --2
 
 

57. Sayfa sayısı ortalama sayfa sayısından fazla olan kitapları listeleyiniz.


select * from kitap where sayfasayisi >(select avg(sayfasayisi) from kitap)

1
2
3
 
select * from kitap where sayfasayisi >(select avg(sayfasayisi) from kitap)
 
 

58.İç içe select ile dram türündeki kitapları listeleyiniz.


select * from kitap where kitap.kitapno=(select (kitap.kitapno) from tur where turadi='dram')

1
2
3
 
select * from kitap where kitap.kitapno=(select (kitap.kitapno) from tur where turadi='dram')
 
 

59.Adı e harfi ile başlayan yazarların kitapları


select * from kitap where kitap.yazarno in (select yazar.yazarno from yazar where yazarad like 'e%')

1
2
3
 
select * from kitap where kitap.yazarno in (select yazar.yazarno from yazar where yazarad like 'e%')
 
 

60.İç içe sorgu ile kitap okumayan öğrencileri listeleyiniz.


select * from ogrenci where ogrenci.ogrno not in ( select distinct islem.ogrno from islem)

1
2
3
 
select * from ogrenci where ogrenci.ogrno not in ( select distinct islem.ogrno from islem)
 
 

61. İç içe select ile okunmayan kitapları listeleyiniz.


select * from kitap where kitap.kitapno not in (select distinct islem.kitapno from islem)

1
2
3
 
select * from kitap where kitap.kitapno not in (select distinct islem.kitapno from islem)
 
 

62. Mayıs ayında okunmayan kitapları listeleyin.


select * from kitap where kitap.kitapno not in (select distinct islem.kitapno from islem where MONTH(islem.atarih)=5)

1
2
3
 
select * from kitap where kitap.kitapno not in (select distinct islem.kitapno from islem where MONTH(islem.atarih)=5)
 
 

SQL AVG Kullanımı
AVG fonksiyonu ortalama değeri döndürür.

–Tüm kitapların ortalama sayfa sayısını bulunuz.


select avg(sayfasayisi) as [ortalama sayfa] from kitap

1
2
3
 
select avg(sayfasayisi) as [ortalama sayfa] from kitap
 
 

–Sayfa sayısı ortalama sayfanın  üzerindeki kitapları listeleyin.


select kitapadi,sayfasayisi from kitap
where sayfasayisi>(select avg(sayfasayisi) from kitap)

1
2
3
4
 
select kitapadi,sayfasayisi from kitap
where sayfasayisi>(select avg(sayfasayisi) from kitap)
 
SQL COUNT Kullanımı
COUNT fonksiyonu , belirtilen ölçütlerle eşleşen satır sayısını döndürür.

 

–Öğrenci tablosundaki öğrenci sayısını gösterin


select count(*) from ogrenci

1
2
3
 
select count(*) from ogrenci
 
 

–Öğrenci tablosundaki toplam öğrenci sayısını toplam sayı takma(alias kullanımı) adı ile listeleyin.


select count(*) as ogrenciSayisi from ogrenci

1
2
3
 
select count(*) as ogrenciSayisi from ogrenci
 
 

–Öğrenci tablosunda kaç farklı isimde öğrenci olduğunu listeleyiniz.


select count(distinct ograd) from ogrenci

1
2
3
 
select count(distinct ograd) from ogrenci
 
 

SQL MAX Kullanımı
MAX fonksiyonu belirtilen ölçülerle eşleşen en yüksek kayıtı getirir.

 

–En fazla sayfa sayısı olan kitabın sayfa sayısını listeleyiniz.


select max(sayfasayisi) as 'En Fazla Sayfa' from kitap

1
2
3
 
select max(sayfasayisi) as 'En Fazla Sayfa' from kitap
 
 

–En fazla sayfası olan kitabın adını ve sayfa sayısını listeleyiniz.


select kitapadi,sayfasayisi from kitap
where sayfasayisi= (select max(sayfasayisi) from kitap)

1
2
3
4
 
select kitapadi,sayfasayisi from kitap
where sayfasayisi= (select max(sayfasayisi) from kitap)
 
 

SQL MIN Kullanımı
MIN fonksiyonu belirtilen ölçülerle eşleşen en yüksek kayıtı getirir.

 

–En az sayfa sayısı olan kitabın sayfa sayısını listeleyiniz.


select min(sayfasayisi) as 'En Fazla Sayfa' from kitap

1
2
3
 
select min(sayfasayisi) as 'En Fazla Sayfa' from kitap
 
 

–En az sayfası olan kitabın adını ve sayfa sayısını listeleyiniz.


select kitapadi,sayfasayisi from kitap
where sayfasayisi= (select min(sayfasayisi) from kitap)

1
2
3
4
 
select kitapadi,sayfasayisi from kitap
where sayfasayisi= (select min(sayfasayisi) from kitap)
 
 

–Dram türündeki en fazla sayfası olan kitabın sayfa sayısını bulunuz.


select max(sayfasayisi) from kitap,tur 
where kitap.turno=tur.turno and tur.turadi='dram'

1
2
3
4
 
select max(sayfasayisi) from kitap,tur 
where kitap.turno=tur.turno and tur.turadi='dram'
 
 

–numarası 15 olan öğrencinin okuduğu toplam sayfa sayısını bulunuz.


select sum(sayfasayisi) from ogrenci,islem,kitap
where ogrenci.ogrno=islem.ogrno 
and islem.kitapno=kitap.kitapno
and ogrenci.ogrno=15

1
2
3
4
5
6
 
select sum(sayfasayisi) from ogrenci,islem,kitap
where ogrenci.ogrno=islem.ogrno 
and islem.kitapno=kitap.kitapno
and ogrenci.ogrno=15
 
 

 

SQL DATE / SQL DATEDIFF Kullanımı
DATEDIFF :Belirtilen tarihler arasındaki farkı hesaplamak için kullanılır. 

GETDATE :Şuan ki tarih ve zamanı getirir. MySqlde now() fonksiyonu kullanılır.

 

–Öğrencinin adını, soyadını ve yaşını listeleyin.


SELECT ograd, ogrsoyad,DATEDIFF(year,dtarih,GETDATE()) from ogrenci

1
2
3
 
SELECT ograd, ogrsoyad,DATEDIFF(year,dtarih,GETDATE()) from ogrenci
 
 

SQL GROUP BY Kullanımı
–İsme göre öğrenci sayılarının adedini bulunuz.(Örn: ali 5 tane, ahmet 8 tane )


select ograd,count(*) from ogrenci group by ograd

1
2
3
 
select ograd,count(*) from ogrenci group by ograd
 
 

–Her sınıftaki öğrenci sayısını bulunuz.


select sinif, count(*) from ogrenci group by sinif

1
2
3
 
select sinif, count(*) from ogrenci group by sinif
 
 

–Her sınıftaki erkek ve kız öğrenci sayısını bulunuz.


select sinif, cinsiyet,count(*) from ogrenci group by cinsiyet,sinif

1
2
3
 
select sinif, cinsiyet,count(*) from ogrenci group by cinsiyet,sinif
 
 

–Her öğrencinin adını, soyadını ve okuduğu toplam sayfa sayısını büyükten küçüğe doğru  listeleyiniz.


 

select ograd,ogrsoyad,sum(sayfasayisi) as sayfa from ogrenci,kitap,islem
where ogrenci.ogrno=islem.ogrno and kitap.kitapno=islem.kitapno
group by ograd,ogrsoyad,ogrenci.ogrno
order by sayfa

1
2
3
4
5
6
 
select ograd,ogrsoyad,sum(sayfasayisi) as sayfa from ogrenci,kitap,islem
where ogrenci.ogrno=islem.ogrno and kitap.kitapno=islem.kitapno
group by ograd,ogrsoyad,ogrenci.ogrno
order by sayfa
 
–Her öğrencinin okuduğu kitap sayısını getiriniz.


select ograd,ogrsoyad,count(*) as kitapsayisi from ogrenci,kitap,islem
where ogrenci.ogrno=islem.ogrno and kitap.kitapno=islem.kitapno
group by ograd,ogrsoyad,ogrenci.ogrno
order by kitapsayisi

1
2
3
4
5
6
 
select ograd,ogrsoyad,count(*) as kitapsayisi from ogrenci,kitap,islem
where ogrenci.ogrno=islem.ogrno and kitap.kitapno=islem.kitapno
group by ograd,ogrsoyad,ogrenci.ogrno
order by kitapsayisi









*/
