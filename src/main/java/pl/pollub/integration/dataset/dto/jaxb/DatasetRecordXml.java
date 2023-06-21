package pl.pollub.integration.dataset.dto.jaxb;

import jakarta.xml.bind.annotation.*;
import pl.pollub.integration.dataset.dto.DatasetRecord;

@XmlRootElement(name = "DatasetRecord")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatasetRecordXml {
    @XmlElement
    private int year;

    @XmlElement
    private Double weatherValue;

    @XmlElement
    private Double productionIndex;

    public DatasetRecordXml() {
    }

    public DatasetRecordXml(int year, Double weatherValue, Double productionIndex) {
        this.year = year;
        this.weatherValue = weatherValue;
        this.productionIndex = productionIndex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(Double weatherValue) {
        this.weatherValue = weatherValue;
    }

    public Double getProductionIndex() {
        return productionIndex;
    }

    public void setProductionIndex(Double productionIndex) {
        this.productionIndex = productionIndex;
    }

    public static DatasetRecordXml toJaxbModel(DatasetRecord record) {
        return new DatasetRecordXml(record.year(), record.weatherValue(), record.productionIndex());
    }

}
