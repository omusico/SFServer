/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author 305027939
 */
public class ZXingUtil {

    private ZXingUtil() {
    }

    /**
     *
     * 涓轰簩缁寸爜鍥剧墖澧炲姞logo澶村儚
     *
     * @see 鍏跺師鐞嗙被浼间簬鍥剧墖鍔犳按鍗�
     *
     * @param imagePath 浜岀淮鐮佸浘鐗囧瓨鏀捐矾寰�(鍚枃浠跺悕)
     *
     * @param logoPath logo澶村儚瀛樻斁璺緞(鍚枃浠跺悕)
     *
     */
    private static void overlapImage(String imagePath, String logoPath) throws IOException {

        BufferedImage image = ImageIO.read(new File(imagePath));

        int logoWidth = image.getWidth() / 5;   //璁剧疆logo鍥剧墖瀹藉害涓轰簩缁寸爜鍥剧墖鐨勪簲鍒嗕箣涓� 

        int logoHeight = image.getHeight() / 5; //璁剧疆logo鍥剧墖楂樺害涓轰簩缁寸爜鍥剧墖鐨勪簲鍒嗕箣涓� 

        int logoX = (image.getWidth() - logoWidth) / 2;   //璁剧疆logo鍥剧墖鐨勪綅缃�,杩欓噷浠ゅ叾灞呬腑 

        int logoY = (image.getHeight() - logoHeight) / 2; //璁剧疆logo鍥剧墖鐨勪綅缃�,杩欓噷浠ゅ叾灞呬腑 

        Graphics2D graphics = image.createGraphics();

        graphics.drawImage(ImageIO.read(new File(logoPath)), logoX, logoY, logoWidth, logoHeight, null);

        graphics.dispose();

        ImageIO.write(image, imagePath.substring(imagePath.lastIndexOf(".") + 1), new File(imagePath));

    }

    /**
     *
     * 鐢熸垚浜岀淮鐮�
     *
     * @param content 浜岀淮鐮佸唴瀹�
     *
     * @param charset 缂栫爜浜岀淮鐮佸唴瀹规椂閲囩敤鐨勫瓧绗﹂泦(浼爊ull鏃堕粯璁ら噰鐢║TF-8缂栫爜)
     *
     * @param imagePath 浜岀淮鐮佸浘鐗囧瓨鏀捐矾寰�(鍚枃浠跺悕)
     *
     * @param width 鐢熸垚鐨勪簩缁寸爜鍥剧墖瀹藉害
     *
     * @param height 鐢熸垚鐨勪簩缁寸爜鍥剧墖楂樺害
     *
     * @param logoPath logo澶村儚瀛樻斁璺緞(鍚枃浠跺悕,鑻ヤ笉鍔爈ogo鍒欎紶null鍗冲彲)
     *
     * @return 鐢熸垚浜岀淮鐮佺粨鏋�(true or false)
     *
     */
    public static boolean encodeQRCodeImage(String content, String charset, String imagePath, int width, int height, String logoPath) {

        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();

    //鎸囧畾缂栫爜鏍煎紡 
    //hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); 
    //鎸囧畾绾犻敊绾у埆(L--7%,M--15%,Q--25%,H--30%) 
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

    //缂栫爜鍐呭,缂栫爜绫诲瀷(杩欓噷鎸囧畾涓轰簩缁寸爜),鐢熸垚鍥剧墖瀹藉害,鐢熸垚鍥剧墖楂樺害,璁剧疆鍙傛暟 
        BitMatrix bitMatrix = null;

        try {

            bitMatrix = new MultiFormatWriter().encode(new String(content.getBytes(charset == null ? "UTF-8" : charset), "ISO-8859-1"), BarcodeFormat.QR_CODE, width, height, hints);

        } catch (Exception e) {

            System.out.println("缂栫爜寰呯敓鎴愪簩缁寸爜鍥剧墖鐨勬枃鏈椂鍙戠敓寮傚父,鍫嗘爤杞ㄨ抗濡備笅");

            e.printStackTrace();

            return false;

        }

    //鐢熸垚鐨勪簩缁寸爜鍥剧墖榛樿鑳屾櫙涓虹櫧鑹�,鍓嶆櫙涓洪粦鑹�,浣嗘槸鍦ㄥ姞鍏ogo鍥惧儚鍚庝細瀵艰嚧logo涔熷彉涓洪粦鐧借壊,鑷充簬鏄粈涔堝師鍥犺繕娌℃湁浠旂粏鍘昏瀹冪殑婧愮爜 
    //鎵�浠ヨ繖閲屽鍏剁涓�涓弬鏁伴粦鑹插皢ZXing榛樿鐨勫墠鏅壊0xFF000000绋嶅井鏀逛簡涓�涓�0xFF000001,鏈�缁堟晥鏋滀篃鏄櫧鑹茶儗鏅粦鑹插墠鏅殑浜岀淮鐮�,涓攍ogo棰滆壊淇濇寔鍘熸湁涓嶅彉 
        MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);

    //杩欓噷瑕佹樉寮忔寚瀹歁atrixToImageConfig,鍚﹀垯杩樹細鎸夌収榛樿澶勭悊灏唋ogo鍥惧儚涔熷彉涓洪粦鐧借壊(濡傛灉鎵撶畻鍔爈ogo鐨勮瘽,鍙嶄箣鍒欎笉椤讳紶MatrixToImageConfig鍙傛暟) 
        try {

            MatrixToImageWriter.writeToFile(bitMatrix, imagePath.substring(imagePath.lastIndexOf(".") + 1), new File(imagePath), config);

        } catch (IOException e) {

            System.out.println("鐢熸垚浜岀淮鐮佸浘鐗嘯" + imagePath + "]鏃堕亣鍒板紓甯�,鍫嗘爤杞ㄨ抗濡備笅");

            e.printStackTrace();

            return false;

        }

    //姝ゆ椂浜岀淮鐮佸浘鐗囧凡缁忕敓鎴愪簡,鍙笉杩囨病鏈塴ogo澶村儚,鎵�浠ユ帴涓嬫潵鏍规嵁浼犲叆鐨刲ogoPath鍙傛暟鏉ュ喅瀹氭槸鍚﹀姞logo澶村儚 
        if (null == logoPath) {

            return true;

        } else {

        //濡傛灉姝ゆ椂鏈�缁堢敓鎴愮殑浜岀淮鐮佷笉鏄垜浠兂瑕佺殑,閭ｄ箞鍙互鎵╁睍MatrixToImageConfig绫�(鍙嶆ZXing鎻愪緵浜嗘簮鐮�) 
        //鎵╁睍鏃跺彲浠ラ噸鍐欏叾writeToFile鏂规硶,浠ゅ叾杩斿洖toBufferedImage()鏂规硶鎵�鐢熸垚鐨凚ufferedImage瀵硅薄(灏界杩欑鍋氭硶鏈繀鑳借В鍐充负棰�,鏁呴渶鏍规嵁瀹為檯鎯呮櫙娴嬭瘯) 
        //鐒跺悗鏇挎崲杩欓噷overlapImage()閲岄潰鐨勭涓�琛孊ufferedImage image = ImageIO.read(new File(imagePath)); 
        //鍗硃rivate static void overlapImage(BufferedImage image, String imagePath, String logoPath) 
            try {

            //杩欓噷涓嶉渶瑕佸垽鏂璴ogoPath鏄惁鎸囧悜浜嗕竴涓叿浣撶殑鏂囦欢,鍥犱负杩欑鎯呮櫙涓媜verlapImage浼氭姏IO寮傚父 
                overlapImage(imagePath, logoPath);

                return true;

            } catch (IOException e) {

                System.out.println("涓轰簩缁寸爜鍥剧墖[" + imagePath + "]娣诲姞logo澶村儚[" + logoPath + "]鏃堕亣鍒板紓甯�,鍫嗘爤杞ㄨ抗濡備笅");

                e.printStackTrace();

                return false;

            }

        }

    }

    /**
     *
     * 瑙ｆ瀽浜岀淮鐮�
     *
     * @param imagePath 浜岀淮鐮佸浘鐗囧瓨鏀捐矾寰�(鍚枃浠跺悕)
     *
     * @param charset 瑙ｇ爜浜岀淮鐮佸唴瀹规椂閲囩敤鐨勫瓧绗﹂泦(浼爊ull鏃堕粯璁ら噰鐢║TF-8缂栫爜)
     *
     * @return 瑙ｆ瀽鎴愬姛鍚庤繑鍥炰簩缁寸爜鏂囨湰,鍚﹀垯杩斿洖绌哄瓧绗︿覆
     *
     */
    public static String decodeQRCodeImage(String imagePath, String charset) {

        BufferedImage image = null;

        try {

            image = ImageIO.read(new File(imagePath));

        } catch (IOException e) {

            e.printStackTrace();

            return "";

        }

        if (null == image) {

            System.out.println("Could not decode QRCodeImage");

            return "";

        }

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

        Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();

        hints.put(DecodeHintType.CHARACTER_SET, charset == null ? "UTF-8" : charset);

        Result result = null;

        try {

            result = new MultiFormatReader().decode(bitmap, hints);

            return result.getText();

        } catch (NotFoundException e) {

            System.out.println("浜岀淮鐮佸浘鐗嘯" + imagePath + "]瑙ｆ瀽澶辫触,鍫嗘爤杞ㄨ抗濡備笅");

            e.printStackTrace();

            return "";

        }

    }

}
