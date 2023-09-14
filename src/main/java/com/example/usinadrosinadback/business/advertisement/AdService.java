package com.example.usinadrosinadback.business.advertisement;

import com.example.usinadrosinadback.business.advertisement.dto.*;
import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementMapper;
import com.example.usinadrosinadback.domain.advertisement.AdvertisementService;
import com.example.usinadrosinadback.domain.advertisement.chore.Chore;
import com.example.usinadrosinadback.domain.advertisement.chore.ChoreMapper;
import com.example.usinadrosinadback.domain.advertisement.chore.ChoreService;
import com.example.usinadrosinadback.domain.advertisement.tool.Tool;
import com.example.usinadrosinadback.domain.advertisement.tool.ToolMapper;
import com.example.usinadrosinadback.domain.advertisement.tool.ToolService;
import com.example.usinadrosinadback.domain.advertisement.type.Type;
import com.example.usinadrosinadback.domain.advertisement.type.TypeMapper;
import com.example.usinadrosinadback.domain.advertisement.type.TypeService;
import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChore;
import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChoreService;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;

@Service
public class AdService {

    @Resource
    private AdvertisementChoreService advertisementChoreService;

    @Resource
    private ChoreService choreService;

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
    private ChoreMapper choreMapper;

    @Resource
    private ToolMapper toolMapper;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Transactional
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

    public List<TypeDto> getAllAdvertisementTypes() {
        List<Type> advertisementTypes = typeService.getAllAdvertisementTypes();
        return typeMapper.toTypeDtos(advertisementTypes);
    }

    public List<ToolDto> getAllAdvertisementTools() {
        List<Tool> advertisementTools = toolService.getAllAdvertisementTools();
        return toolMapper.toToolDtos(advertisementTools);

    }

    public List<ChoreDto> getAllChores() {
        List<Chore> chores = choreService.getAllChores();
        return choreMapper.toChoreDtos(chores);
    }

    @Transactional
    public void addAdvertisementChore(AdvertisementChoreDto request) {
        AdvertisementChore advertisementChore = new AdvertisementChore();
        getAndSetChoreToAdvertisementChore(request, advertisementChore);
        getAndSetAdvertisementToAdvertisementChore(request, advertisementChore);
        advertisementChoreService.saveAdvertisementChore(advertisementChore);
    }

    private void getAndSetChoreToAdvertisementChore(AdvertisementChoreDto request, AdvertisementChore advertisementChore) {
        Chore chore = choreService.getChoreBy(request.getChoreId());
        advertisementChore.setChore(chore);
    }

    private void getAndSetAdvertisementToAdvertisementChore(AdvertisementChoreDto request, AdvertisementChore advertisementChore) {
        Advertisement advertisement = advertisementService.getAdvertisementBy(request.getAdvertisementId());
        advertisementChore.setAdvertisement(advertisement);
    }

    public void deleteAdvertisementChore(Integer choreId, Integer advertisementId) {
        advertisementChoreService.deleteAdvertisementChore(choreId, advertisementId);
    }

    public void deleteAllAdvertisementChores(Integer advertisementId) {
        advertisementChoreService.deleteAllAdvertisementsChores(advertisementId);
    }

    public void deleteAdvertisement(Integer advertisementId) {
        advertisementService.deleteAdvertisement(advertisementId);
    }
}
