public class Main {



    public static void main(String[] args) {
        ikiliAramaAgac bst = new ikiliAramaAgac();
        bst.Ekle(10);
        bst.Ekle(5);
        bst.Ekle(8);
        bst.Ekle(20);
        bst.Ekle(3);
        bst.Ekle(28);
        bst.Ekle(17);

        bst.levelOrderTraverse();
    }
}
