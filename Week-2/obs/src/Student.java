public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    Course matV;
    Course fizikV;
    Course kimyaV;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya, Course matV,Course fizikV,Course kimyaV) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.matV = matV;
        this.fizikV = fizikV;
        this.kimyaV = kimyaV;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkVerbelNote(int matV, int fizikV, int kimyaV) {

        if (matV >= 0 && matV <= 100) {
            this.matV.note = matV;
        }

        if (fizikV >= 0 && fizikV <= 100) {
            this.fizikV.note = fizikV;
        }

        if (kimyaV >= 0 && kimyaV <= 100) {
            this.kimyaV.note = kimyaV;
        }

    }

    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.note * 0.8) + (this.fizikV.note * 0.2)
                + (this.kimya.note * 0.8) + (this.kimyaV.note * 0.2)
                + (this.mat.note * 0.8) + (this.matV.note * 0.2)) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}