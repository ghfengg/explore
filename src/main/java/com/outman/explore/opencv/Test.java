package com.outman.explore.opencv;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Test {

    static {
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.load("/Users/outman/git-workspace/explore/src/main/java/macos/opencv_java2413.dylib");
    }

    public static void main(String[] args) {

        Mat img1 = Highgui.imread("/Users/outman/git-workspace/explore/src/main/java/macos/compare1.png");
        Mat img2 = Highgui.imread("/Users/outman/git-workspace/explore/src/main/java/macos/compare2.png");

        Mat img = new Mat();
        Mat erodeImg = new Mat();
        Mat dilateImg = new Mat();
        Mat threshImg = new Mat();
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();

        Mat hierarchy = new Mat();
        // 像素做差
        Core.absdiff(img1, img2, img);

        Mat kernel = Imgproc.getStructuringElement(1, new Size(4, 6));
        Mat kernel1 = Imgproc.getStructuringElement(1, new Size(2, 3));
        // 腐蚀
        Imgproc.erode(img, erodeImg, kernel, new Point(-1, -1), 1);
        // 膨胀
        Imgproc.dilate(erodeImg, dilateImg, kernel1);
        // 检测边缘
        Imgproc.threshold(dilateImg, threshImg, 20, 255, Imgproc.THRESH_BINARY);
        // 转化成灰度
        Imgproc.cvtColor(threshImg, threshImg, Imgproc.COLOR_RGB2GRAY);
        // 找到轮廓(3：CV_RETR_TREE，2：CV_CHAIN_APPROX_SIMPLE)
        Imgproc.findContours(threshImg, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE,
            new Point(0, 0));

        List<Rect> boundRect = new ArrayList<Rect>(contours.size());
        for (int i = 0; i < contours.size(); i++) {
            // Mat conMat = (Mat)contours.get(i);
            // Imgproc.approxPolyDP((MatOfPoint2f)conMat,contours_poly.get(i),3,true);
            // 根据轮廓生成外包络矩形
            Rect rect = Imgproc.boundingRect(contours.get(i));
            boundRect.add(rect);
        }

        for (int i = 0; i < contours.size(); i++) {
            Scalar color = new Scalar(0, 0, 255);
            // 绘制轮廓
            // Imgproc.drawContours(img1, contours, i, color, 1, Core.LINE_8, hierarchy, 0, new Point());
            // 绘制矩形
            Core.rectangle(img1, boundRect.get(i).tl(), boundRect.get(i).br(), color, 2, Core.LINE_8, 0);
        }

        Highgui.imwrite("/Users/outman/git-workspace/explore/src/main/java/macos/diff2.png", img);
    }
    
}
