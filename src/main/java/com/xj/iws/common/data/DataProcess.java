package com.xj.iws.common.data;

import com.xj.iws.common.enums.DataEnum;
import com.xj.iws.common.utils.ByteUtil;
import com.xj.iws.http.mvc.dao.PointRoleDao;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.DataField;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.ViewDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/16.
 */
@Component
public class DataProcess {

    @Autowired
    PointRoleDao pointRoleDao;

    List<Map<String,String>> status;

    public List<PointFieldEntity> pointFields;

    public DataProcess() {
    }

    public void enable(List<PointFieldEntity> pointFields) {
        this.pointFields = pointFields;
        status = pointRoleDao.getStatus(0);
    }

    public List<ViewDataEntity> process(List<DataEntity> datas) {
        List<ViewDataEntity> viewDatas = new ArrayList<ViewDataEntity>();
        for (DataEntity data : datas) {

            String port = data.getPort();
            String number = data.getNumber();
            Date time = data.getTime();
            int count = data.getCount();
            String addressName = data.getAddressName();
            String locationName = data.getLocationName();
            String roomName = data.getRoomName();
            String groupName = data.getGroupName();

            String[] arrayData = DataFormat.subData(data.getData(),4);
            List<DataField> dataFields = analyze(arrayData);

            ViewDataEntity viewData = new ViewDataEntity(port,number,time,DataEnum.No_Exception,count,addressName,locationName,roomName,groupName,dataFields);
            if (!"ER".equals(data.getError())){
                viewData.setException(DataEnum.Exception);
            }
            viewDatas.add(viewData);
        }
        return viewDatas;
    }

    private List<DataField> analyze(String[] data) {
        List<DataField> dataFields = new ArrayList<DataField>();
        for (int i = 0; i < pointFields.size(); i++) {

            PointFieldEntity field = pointFields.get(i);
            DataField dataField;

            switch (field.getRoleId()) {
                case 1:
                    dataField = role01(data[i],field);
                    break;
                case 2:
                    dataField = role02(data[i]);
                    break;
                case 3:
                    dataField = role03(data[i]);
                    break;
                case 4:
                    dataField = role04(data[i]);
                    break;
                case 5:
                    dataField = role05(data[i]);
                    break;
                default:
                    dataField = new DataField();
                    break;
            }
            dataField.setNumber(i);
            dataField.setName(field.getName());
            dataFields.add(dataField);
        }
        return dataFields;
    }

    private DataField role01(String s, PointFieldEntity field) {
        DataField data = new DataField();
        double value = Double.valueOf(s) / field.getMultiple();
        if (value < field.getMin() || value > field.getMax()) {
            data.setException(DataEnum.Exception);
        }
        data.setData(String.valueOf(value)+field.getUnit());
        return data;
    }

    private DataField role02(String s) {
        DataField data = new DataField();
        StringBuffer value = new StringBuffer();

        s = ByteUtil.hexToBinary(s);
        s = s.substring(8,16);
        char[] point = s.toCharArray();
        for (int j = 0; j <point.length ; j++) {
            if (point[j] == '1'){
                value.append(status.get(1).get(String.valueOf(j+1))+" ");
            }
        }
        if (point[5] == '1') {
            data.setException(DataEnum.Exception);
        }
        data.setData(String.valueOf(value));
        return data;
    }

    private DataField role03(String s) {
        DataField data = new DataField();

        StringBuffer value = new StringBuffer();

        s = ByteUtil.hexToBinary(s);
        s = s.substring(10,16);
        char[] point = s.toCharArray();
        for (int j = 0; j <point.length ; j++) {
            if (point[j] == '1'){
                value.append(status.get(2).get(String.valueOf(j+1))+" ");
                data.setData(String.valueOf(value));
                data.setException(DataEnum.Exception);
            }
        }
        return data;
    }

    private DataField role04(String s) {
        DataField data = new DataField();
        int i = Integer.parseInt(s);
        data.setData(status.get(3).get(String.valueOf(i+1)));
        return data;
    }

    private DataField role05(String s) {
        DataField data = new DataField();
        int i = Integer.parseInt(s);
        data.setData(status.get(4).get(String.valueOf(i+1)));
        return data;
    }
}
