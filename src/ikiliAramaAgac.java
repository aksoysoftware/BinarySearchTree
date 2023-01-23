import java.util.LinkedList;
import java.util.Queue;

public class ikiliAramaAgac {
    public ikiliAgacDugum kok;

    /*
    level order kodla , çakışmaları kodla
     */

    public ikiliAramaAgac() {//sınıfın ilk foksiyonunu yani yapıcı metodunu yazarız
        this.kok = null;//default degerini yazarız
    }

    public void Ekle(int deger) {
        ikiliAgacDugum yeni = new ikiliAgacDugum(deger);//yeni adında bir dugum olustururuz
        if (this.kok == null) {//eger kok yok ise
            this.kok = yeni;
            System.out.println("kok" + deger);
            return;
        }
        ikiliAgacDugum parent = null;
        ikiliAgacDugum aktif = this.kok;//temp degiskeni olustururuz koke atarız

        while (true) {
            parent = aktif;
            if (deger < aktif.veri) {
                aktif = aktif.sol;
                if (aktif == null) {
                    parent.sol = yeni;
                    System.out.println("Parent" + parent.veri + "Soluna eklenen" + yeni.veri);
                    return;
                }
            } else if (deger > aktif.veri) {
                aktif = aktif.sag;
                if (aktif == null) {
                    parent.sag = yeni;
                    System.out.println("Parent" + parent.veri + "Sagina eklenen" + yeni.veri);
                    return;
                }

            } else {
                System.out.println("Bu deger var");
                return;
            }
        }
    }

    public ikiliAgacDugum minDugum() {
        if (this.kok == null)
            return null;
        ikiliAgacDugum aktif = this.kok;
        while (aktif.sol != null) {
            aktif = aktif.sol;
        }
        return aktif;
    }

    public ikiliAgacDugum maxDugum() {
        if (this.kok == null)
            return null;
        ikiliAgacDugum aktif = this.kok;
        while (aktif.sag != null) {
            aktif = aktif.sag;
        }
        return aktif;
    }


    public void inOrderDolasma(ikiliAgacDugum localRoot) {
        if (localRoot != null) {

            inOrderDolasma(localRoot.sol);
            localRoot.yazdir();
            inOrderDolasma(localRoot.sag);
            localRoot.yazdir();


        }
    }

    public void levelOrderTraverse() {
        Queue<ikiliAgacDugum> que = new LinkedList<>();
        que.add(this.kok);
        ikiliAgacDugum temp;
        while (!que.isEmpty()) {
            temp = que.poll();
            temp.yazdir();
            if (temp.sag == null) {
                que.add(temp.sag);
            }
            if (temp.sol == null) {
                que.add(temp.sol);
            }
        }
    }


}
