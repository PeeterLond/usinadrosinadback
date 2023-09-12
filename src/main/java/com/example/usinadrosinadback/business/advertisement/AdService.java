package com.example.usinadrosinadback.business.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.AdvertisementDto;
import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementMapper;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementService;
import com.example.usinadrosinadback.domain.advertisement.tool.Tool;
import com.example.usinadrosinadback.domain.advertisement.tool.ToolService;
import com.example.usinadrosinadback.domain.advertisement.type.Type;
import com.example.usinadrosinadback.domain.advertisement.type.TypeService;
import com.example.usinadrosinadback.domain.location.coordinate.Coordinate;
import com.example.usinadrosinadback.domain.location.city.City;
import com.example.usinadrosinadback.domain.location.city.CityService;
import com.example.usinadrosinadback.domain.location.coordinate.CoordinateService;
import com.example.usinadrosinadback.domain.location.county.County;
import com.example.usinadrosinadback.domain.location.county.CountyService;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.util.Time;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AdService {

    @Resource
    private AdvertisementService advertisementService;

    @Resource
    private CoordinateService coordinateService;

    @Resource
    private TypeService typeService;

    @Resource
    private ToolService toolService;

    @Resource
    private CityService cityService;

    @Resource
    private CountyService countyService;

    @Resource
    private UserService userService;

    @Resource
    private AdvertisementMapper advertisementMapper;

    public Integer addAdvertisement(AdvertisementDto request) {
        Advertisement advertisement = advertisementMapper.toAdvertisement(request);

        getAndSetUserToAdvertisement(request, advertisement);
        getAndSetCountyToAdvertisement(request, advertisement);
        validateAndSetCityToAdvertisement(request, advertisement);
        getAndSetToolToAdvertisement(request, advertisement);
        getAndSetTypeToAdvertisement(request, advertisement);
        getAndSetTimeToAdvertisement(advertisement);
        validateAndSetCoordinateToAdvertisement(request, advertisement);

        advertisementService.saveAdvertisement(advertisement);
        return advertisement.getId();

    }

    private void getAndSetUserToAdvertisement(AdvertisementDto request, Advertisement advertisement) {
        User user = userService.getUserBy(request.getUserId());
        advertisement.setUser(user);
    }

    private void getAndSetCountyToAdvertisement(AdvertisementDto request, Advertisement advertisement) {
        County county = countyService.getCountyBy(request.getCountyId());
        advertisement.setCounty(county);
    }

    private void validateAndSetCityToAdvertisement(AdvertisementDto request, Advertisement advertisement) {
        if (advertisementHasCity(request.getCityId())) {
            City city = cityService.getCityBy(request.getCityId());
            advertisement.setCity(city);
        }
    }

    private static boolean advertisementHasCity(Integer cityId) {
        return !cityId.equals(0);
    }

    private void getAndSetToolToAdvertisement(AdvertisementDto request, Advertisement advertisement) {
        Tool tool = toolService.getToolBy(request.getToolId());
        advertisement.setTool(tool);
    }

    private void getAndSetTypeToAdvertisement(AdvertisementDto request, Advertisement advertisement) {
        Type type = typeService.getTypeBy(request.getTypeId());
        advertisement.setType(type);
    }

    private static void getAndSetTimeToAdvertisement(Advertisement advertisement) {
        Instant currentTimeStamp = Time.getCurrentTimeStamp();
        advertisement.setTime(currentTimeStamp);
    }

    private void validateAndSetCoordinateToAdvertisement(AdvertisementDto request, Advertisement advertisement) {
        if (advertisementHasCoordinates(request)) {
            Coordinate coordinate = new Coordinate();

            coordinate.setLat(request.getCoordinateLat());
            coordinate.setLongField(request.getCoordinateLongField());

            coordinateService.saveCoordinate(coordinate);
            advertisement.setCoordinate(coordinate);
        }
    }

    private static boolean advertisementHasCoordinates(AdvertisementDto request) {
        return request.getCoordinateLat() != null && request.getCoordinateLongField() != null;
    }
}
