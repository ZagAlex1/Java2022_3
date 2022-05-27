package java_3.lessons.Grigoriev.Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Classwork {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        fileExample();
//        simpleFileWrite();
//        simpleFileRead();
//        bufferingExample();
//        readWithReaderExample();
//        sequenseExample();
//        randomExample();
//        simpleSerializableExample();

        CatEx cat = new CatEx("Murzik", "red");


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example/murzic.sr"))) {
            oos.writeObject(cat);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example/murzic.sr"))) {
            CatEx deserialized = (CatEx) ois.readObject();

            System.out.println(cat);
            System.out.println(deserialized);
            System.out.println(cat == deserialized);
            System.out.println(cat.equals(deserialized));
        }

    }

    private static void simpleSerializableExample() throws IOException, ClassNotFoundException {
        Cat cat = new Cat("Barsik", "red");


//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("example/barsik.sr"))) {
//            oos.writeObject(cat);
//        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example/barsik.sr"))) {
            Cat deserialized = (Cat) ois.readObject();

            System.out.println(cat);
            System.out.println(deserialized);
            System.out.println(cat == deserialized);
            System.out.println(cat.equals(deserialized));
        }
    }

    private static void randomExample() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("example/ex1.txt", "r")) {
            int b;
            raf.seek(10);
            while ((b = raf.read()) != -1) {
                System.out.print((char) b);
            }
        }
    }

    private static void sequenseExample() throws IOException {
        ArrayList<InputStream> streams = new ArrayList<>();
        streams.add(new FileInputStream("example/ex1.txt"));
        streams.add(new FileInputStream("example/ex3.txt"));
        streams.add(new FileInputStream("example/ex4.txt"));

        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(streams));

        int b;
        while ((b = sis.read()) != -1) {
            System.out.print((char) b);
        }
    }

    private static void readWithReaderExample() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("example/ex1.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
            br.lines()
                    .distinct()
//                    .filter(s -> s.contains(" "))
                    .forEach(System.out::println);
        }
    }

    private static void bufferingExample() throws IOException {
//        long start = System.currentTimeMillis();
//        try (FileInputStream fis = new FileInputStream("example/ex2.txt")) {
//            int b;
//            while ((b = fis.read()) > -1) {
////                System.out.print((char) b);
//            }
//        }
//        System.out.println(System.currentTimeMillis() - start);

//        long start = System.currentTimeMillis();
//        byte[] buf = new byte[512];
//
//        try (FileInputStream fis = new FileInputStream("example/ex2.txt")) {
//            int b;
//            while ((b = fis.read(buf)) > -1) {
////                System.out.print((char) b);
//            }
//        }
//        System.out.println(System.currentTimeMillis() - start);

        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("example/ex2.txt"))) {
            int b;
            while ((b = bis.read()) > -1) {
                ///
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void simpleFileRead() throws IOException {
        try (FileInputStream fis = new FileInputStream("example/ex2.txt")) {
            int b;
            while ((b = fis.read()) > -1) {
                System.out.print((char) b);
            }
        }
    }

    private static void simpleFileWrite() throws IOException {
        File file = new File("example/ex1.txt");
        String s = "Hello world";

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(s.getBytes());
        }
    }

    private static void fileExample() throws IOException {
        File file = new File("example/ex1.txt");
        System.out.println(file.exists());
        File dir = new File("example");
        System.out.println(dir.exists());

        if (!dir.exists()) {
            dir.mkdir();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(dir.isDirectory());
//        System.out.println(dir.isFile());
//
//        file.delete();
//        System.out.println(file.exists());

        File dir2 = new File("example/1/2/3/4/5/6/7/8/9");
//        System.out.println(dir2.mkdir());
//        System.out.println(dir2.mkdirs()); // создание полного дерева папок

//        String[] list = dir2.list();
//        for (String s : list) {
//            System.out.println(s);
//        }

//        File[] list = dir2.listFiles();
//        for (File file1 : list) {
//            System.out.println(file1);
//        }

//        File[] list = dir2.listFiles((d, name) -> name.endsWith(".xls"));
//        for (File file1 : list) {
//            System.out.println(file1);
//        }

//        File[] list = dir2.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".xls");
//            }
//        });
//        for (File file1 : list) {
//            System.out.println(file1);
//        }

//        File[] list = dir2.listFiles(File::isFile);
//        for (File file1 : list) {
//            System.out.println(file1);
//        }
//        recursiveFileWalk(new File("example"));
    }

    private static void recursiveFileWalk(File root) {
        if (root.isFile()) {
            System.out.println("File -->> " + root.getPath());
        } else {
            System.out.println("Catalog -->> " + root.getPath());
            File[] files = root.listFiles();
            for (File file : files) {
                recursiveFileWalk(file);
            }
        }
    }
}
