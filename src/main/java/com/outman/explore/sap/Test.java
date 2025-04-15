package com.outman.explore.sap;

import com.sap.conn.jco.*;
import com.sap.conn.jco.ext.DestinationDataProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author yangfeng
 * @date 2024/12/11
 * @description: 描述信息
 */
public class Test {

    public static void main(String[] args) {
        // 注册DestinationDataProvider
        Properties connectProperties = new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "172.16.5.134");
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "800");
        connectProperties.setProperty(DestinationDataProvider.JCO_USER, "liaoji");
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "123456");
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "ZH");

        createDestinationDataFile("ABAP_AS", connectProperties);

        try {
            // 获取连接目标
            JCoDestination destination = JCoDestinationManager.getDestination("ABAP_AS");
            JCoRepository repository = destination.getRepository();
            JCoFunction function = repository.getFunction("BAPI_USER_GET_DETAIL");

            if (function == null) {
                throw new RuntimeException("BAPI_USER_GET_DETAIL not found in SAP.");
            }

            // 设置输入参数
            function.getImportParameterList().setValue("USERNAME", "testuser");

            // 执行远程函数调用
            function.execute(destination);

            // 获取输出参数
            JCoParameterList tables = function.getTableParameterList();
            JCoStructure address = tables.getStructure("ADDRESS");

            if (address != null) {
                String street = address.getString("STREET");
                String city = address.getString("CITY");
                System.out.println("Street: " + street);
                System.out.println("City: " + city);
            }
        } catch (JCoException e) {
            e.printStackTrace();
        }
    }

    private static void createDestinationDataFile(String destinationName, Properties connectProperties) {
        File destCfg = new File(destinationName + ".jcoDestination");
        try (FileOutputStream fos = new FileOutputStream(destCfg, false)) {
            connectProperties.store(fos, "SAP destination configuration");
        } catch (Exception e) {
            throw new RuntimeException("Unable to create the destination file", e);
        }
    }

}
