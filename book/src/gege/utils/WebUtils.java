package gege.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author Mr.xu
 * @create 2022/03/30/15:34
 * Description:
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {

        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }


    /**
     * 将字符串转为int数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }
}
