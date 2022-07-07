package utils;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import сore.entity.Capabilities;
import сore.entity.Device;

import java.util.List;
import java.util.stream.Collectors;

public class YamlParser {
    private Yaml yaml;

    public Capabilities getCapabilitiesForDevice(String deviceName) {
        yaml = new Yaml(new Constructor(Capabilities.class));

        return new Capabilities(
                getDeviceWhichEqualsName(deviceName),
                getDeviceWhichEqualsName(deviceName).get(0),
                getCapabilitiesFromYaml().getPathToMyApp(),
                getCapabilitiesFromYaml().getMyAppPackage(),
                getCapabilitiesFromYaml().getMyAppActivity()
        );
    }

    private List<Device> getDeviceWhichEqualsName(String deviceName) {
        return getCapabilitiesFromYaml()
                .getDevices()
                .stream()
                .filter(device -> {
                    return device.getDeviceName().equals(deviceName);
                })
                .collect(Collectors.toList());
    }

    private Capabilities getCapabilitiesFromYaml() {
        var inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yamls/conf.yaml");
        return yaml.load(inputStream);
    }
}