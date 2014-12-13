/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaoyou.platform.server.utils;

/**
 *
 * @author 305027939
 */
public class UnicodeConverter {


    private static final char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
        'B', 'C', 'D', 'E', 'F'};

    private static char toHex(int nibble) {
        return hexDigit[(nibble & 0xF)];
    }

    /**
     * 灏嗗瓧绗︿覆缂栫爜鎴� Unicode 褰㈠紡鐨勫瓧绗︿覆. 濡� "榛�" to "\u9EC4" Converts unicodes to encoded
     * \\uxxxx and escapes special characters with a preceding slash
     *
     * @param theString 寰呰浆鎹㈡垚Unicode缂栫爜鐨勫瓧绗︿覆銆�
     * @param escapeSpace 鏄惁蹇界暐绌烘牸锛屼负true鏃跺湪绌烘牸鍚庨潰鏄惁鍔犱釜鍙嶆枩鏉犮��
     * @return 杩斿洖杞崲鍚嶶nicode缂栫爜鐨勫瓧绗︿覆銆�
     */
    public static String toEncodedUnicode(String theString, boolean escapeSpace) {
        int len = theString.length();
        int bufLen = len * 2;
        if (bufLen < 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuffer outBuffer = new StringBuffer(bufLen);

        for (int x = 0; x < len; x++) {
            char aChar = theString.charAt(x);
            // Handle common case first, selecting largest block that
            // avoids the specials below
            if ((aChar > 61) && (aChar < 127)) {
                if (aChar == '\\') {
                    outBuffer.append('\\');
                    outBuffer.append('\\');
                    continue;
                }
                outBuffer.append(aChar);
                continue;
            }

            switch (aChar) {
                case ' ':
                    if (x == 0 || escapeSpace) {
                        outBuffer.append('\\');
                    }
                    outBuffer.append(' ');
                    break;
                case '\t':
                    outBuffer.append('\\');
                    outBuffer.append('t');
                    break;
                case '\n':
                    outBuffer.append('\\');
                    outBuffer.append('n');
                    break;
                case '\r':
                    outBuffer.append('\\');
                    outBuffer.append('r');
                    break;
                case '\f':
                    outBuffer.append('\\');
                    outBuffer.append('f');
                    break;
                case '=': // Fall through
                case ':': // Fall through
                case '#': // Fall through
                case '!':
                    outBuffer.append('\\');
                    outBuffer.append(aChar);
                    break;
                default:
                    if ((aChar < 0x0020) || (aChar > 0x007e)) {
                        // 姣忎釜unicode鏈�16浣嶏紝姣忓洓浣嶅搴旂殑16杩涘埗浠庨珮浣嶄繚瀛樺埌浣庝綅
                        outBuffer.append('\\');
                        outBuffer.append('u');
                        outBuffer.append(toHex((aChar >> 12) & 0xF));
                        outBuffer.append(toHex((aChar >> 8) & 0xF));
                        outBuffer.append(toHex((aChar >> 4) & 0xF));
                        outBuffer.append(toHex(aChar & 0xF));
                    } else {
                        outBuffer.append(aChar);
                    }
            }
        }
        return outBuffer.toString();
    }

    /**
     * 浠� Unicode 褰㈠紡鐨勫瓧绗︿覆杞崲鎴愬搴旂殑缂栫爜鐨勭壒娈婂瓧绗︿覆銆� 濡� "\u9EC4" to "榛�". Converts encoded
     * \\uxxxx to unicode chars and changes special saved chars to their
     * original forms
     *
     * @param in Unicode缂栫爜鐨勫瓧绗︽暟缁勩��
     * @param off 杞崲鐨勮捣濮嬪亸绉婚噺銆�
     * @param len 杞崲鐨勫瓧绗﹂暱搴︺��
     * @param convtBuf 杞崲鐨勭紦瀛樺瓧绗︽暟缁勩��
     * @return 瀹屾垚杞崲锛岃繑鍥炵紪鐮佸墠鐨勭壒娈婂瓧绗︿覆銆�
     */
    public static String fromEncodedUnicode(char[] in, int off, int len) {
        char aChar;
        char[] out = new char[len]; // 鍙煭涓嶉暱
        int outLen = 0;
        int end = off + len;

        while (off < end) {
            aChar = in[off++];
            if (aChar == '\\') {
                aChar = in[off++];
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = in[off++];
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
                        }
                    }
                    out[outLen++] = (char) value;
                } else {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    out[outLen++] = aChar;
                }
            } else {
                out[outLen++] = (char) aChar;
            }
        }
        return new String(out, 0, outLen);
    }
}
