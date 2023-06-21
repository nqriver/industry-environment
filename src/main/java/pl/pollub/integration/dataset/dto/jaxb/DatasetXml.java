package pl.pollub.integration.dataset.dto.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import pl.pollub.integration.dataset.dto.Dataset;
import pl.pollub.integration.dataset.dto.DatasetRecord;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Dataset")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatasetXml {

    @XmlElement
    private String type;

    @XmlElement
    private String measuredWeatherValue;

    @XmlElement
    private List<DatasetRecordXml> records;

    public DatasetXml(String type, String measuredWeatherValue, List<DatasetRecordXml> records) {
        this.type = type;
        this.measuredWeatherValue = measuredWeatherValue;
        this.records = records;
    }


    public DatasetXml() {
    }

    public static DatasetXml toJaxbModel(Dataset dataset) {
        List<DatasetRecordXml> recordXmlList = new ArrayList<>();
        for (DatasetRecord record : dataset.records()) {
            recordXmlList.add(DatasetRecordXml.toJaxbModel(record));
        }
        return new DatasetXml(dataset.type(), dataset.measuredWeatherValue(), recordXmlList);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeasuredWeatherValue() {
        return measuredWeatherValue;
    }

    public void setMeasuredWeatherValue(String measuredWeatherValue) {
        this.measuredWeatherValue = measuredWeatherValue;
    }

    public List<DatasetRecordXml> getRecords() {
        return records;
    }

    public void setRecords(List<DatasetRecordXml> records) {
        this.records = records;
    }
}