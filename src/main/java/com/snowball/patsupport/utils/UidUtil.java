package com.snowball.patsupport.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.zip.CRC32;


public class UidUtil {
    public static String calculateUid(String serialNumber) {
        CRC32 crc32 = new CRC32();
        crc32.update(serialNumber.getBytes());
        String uid = String.format("%08X", crc32.getValue());
        if ((Integer.valueOf(uid.substring(0, 2), 16) & 0x08) == 0x08) {
            uid = StringUtils.join(String.format("%02X", Integer.valueOf(uid.substring(0, 2), 16) & 0xF7),
                    uid.substring(2));
        }
        return uid;
    }

    public static String calculateUid(String serialNumber,String aid) {
        CRC32 crc32 = new CRC32();
        crc32.update(serialNumber.getBytes());
        String uid = String.format("%08X", crc32.getValue());
        if ((Integer.valueOf(uid.substring(0, 2), 16) & 0x0F) == 0x08) {
            uid = String.format("%02X", Integer.valueOf(uid.substring(0, 2), 16) & 0xF7) + uid.substring(2);
        }
        uid = uid.substring(0,6)+aid.substring(aid.length()-2);
        return uid;
    }

    public static String getAts(String cplc) {
		/*		if (Props.edition.equals("release")) {
		return "107833D00286730167810001" + calculateUid(cplc.substring(24, 36));
	} else {
		return "107833D00286730167810001" + calculateUid(cplc.substring(24, 36),CQTsmConstant.INSTANCE_AID);
	}*/
        return "107833D00286730167810001" + calculateUid(cplc.substring(24, 36));
    }
}
