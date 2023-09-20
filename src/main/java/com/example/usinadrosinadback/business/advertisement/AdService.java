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
import com.example.usinadrosinadback.domain.advertisementChore.AdvertisementChoreMapper;
import com.example.usinadrosinadback.domain.location.coordinate.Coordinate;
import com.example.usinadrosinadback.domain.location.city.City;
import com.example.usinadrosinadback.domain.location.city.CityService;
import com.example.usinadrosinadback.domain.location.coordinate.CoordinateService;
import com.example.usinadrosinadback.domain.location.county.County;
import com.example.usinadrosinadback.domain.location.county.CountyService;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.domain.user.contact.Contact;
import com.example.usinadrosinadback.domain.user.contact.ContactService;
import com.example.usinadrosinadback.util.ImageConverter;
import com.example.usinadrosinadback.util.Time;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdService {

    @Resource
    private ContactService contactService;

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

    public void deleteAdvertisement(Integer advertisementId) {
        advertisementService.deleteAdvertisement(advertisementId);
    }

    public List<AdvertisementContactShowDto> getUserAdvertisementsWithContactBy(Integer userId) {
        List<Advertisement> userAdvertisements = advertisementService.getUserAdvertisementBy(userId);
        return getAndSetContactsToAdvertisementDtos(userAdvertisements);
    }

    public List<AdvertisementContactShowDto> getAllAdvertisementsWithContact() {
        List<Advertisement> allAdvertisements = advertisementService.getAllAdvertisements();
        return getAndSetContactsToAdvertisementDtos(allAdvertisements);
    }

    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByCounty(Integer countyId) {
        List<Advertisement> advertisementsByCounty = advertisementService.getAdvertisementsByCounty(countyId);
        return getAndSetContactsToAdvertisementDtos(advertisementsByCounty);
    }

    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByCity(Integer cityId) {
        List<Advertisement> advertisementsByCity = advertisementService.getAdvertisementsByCity(cityId);
        return getAndSetContactsToAdvertisementDtos(advertisementsByCity);
    }

    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByType(Integer typeId) {
        List<Advertisement> advertisementsByType = advertisementService.getAdvertisementsByType(typeId);
        return getAndSetContactsToAdvertisementDtos(advertisementsByType);
    }

    public List<AdvertisementContactShowDto> getAdvertisementsWithContactByTool(Integer toolId) {
        List<Advertisement> advertisementsByTool = advertisementService.getAdvertisementsByTool(toolId);
        return getAndSetContactsToAdvertisementDtos(advertisementsByTool);
    }

    public AdvertisementDto getAdvertisementBy(Integer advertisementId) {
        Advertisement advertisement = advertisementService.getAdvertisementBy(advertisementId);
        return advertisementMapper.toAdvertisementDto(advertisement);
    }

    @Transactional
    public void updateAdvertisement(Integer advertisementId, AdvertisementDto request) {
        Advertisement advertisement = advertisementService.getAdvertisementBy(advertisementId);
        advertisementMapper.partialUpdate(request, advertisement);

        getAndSetUserToAdvertisement(request, advertisement);
        handleCountyUpdate(request, advertisement);
        handleCityUpdate(request, advertisement);
        handleToolUpdate(request, advertisement);
        handleTypeUpdate(request, advertisement);
        getAndSetTimeToAdvertisement(advertisement);
//        handleCoordinateUpdate(request, advertisement);
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
        if (requestHasCity(request.getCityId())) {
            City city = cityService.getCityBy(request.getCityId());
            advertisement.setCity(city);
        }
    }

    private static boolean requestHasCity(Integer cityId) {
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

    private List<AdvertisementContactShowDto> getAndSetContactsToAdvertisementDtos(List<Advertisement> advertisementsBy) {
        List<AdvertisementContactShowDto> advertisementDtos = advertisementMapper.toAdvertisementDtos(advertisementsBy);
        ArrayList<Contact> contacts = contactService.getAdvertisementsContactInfo(advertisementDtos);
        setContactInfoToAdvertisement(advertisementDtos, contacts);
        return advertisementDtos;
    }

    private static void setContactInfoToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts) {
        for (int i = 0; i < advertisementDtos.size(); i++) {
            advertisementDtos.get(i).setContactFirstName(contacts.get(i).getFirstName());
            advertisementDtos.get(i).setContactLastName(contacts.get(i).getLastName());
            advertisementDtos.get(i).setContactCountyName(contacts.get(i).getCounty().getName());
            validateAndSetContactCityToAdvertisement(advertisementDtos, contacts, i);
            validateAndSetContactImageToAdvertisement(advertisementDtos, contacts, i);
            validateAndSetContactMobileToAdvertisement(advertisementDtos, contacts, i);
            advertisementDtos.get(i).setContactEmail(contacts.get(i).getEmail());
        }
    }

    private static void validateAndSetContactMobileToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts, int i) {
        if (contacts.get(i).getMobileNumber() != null) {
            advertisementDtos.get(i).setContactMobileNumber(contacts.get(i).getMobileNumber());
        }
    }

    private static void validateAndSetContactImageToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts, int i) {
        if (contacts.get(i).getImage() != null) {
            String image = ImageConverter.imageToImageData(contacts.get(i).getImage());
            advertisementDtos.get(i).setContactImageData(image);
        }
    }

    private static void validateAndSetContactCityToAdvertisement(List<AdvertisementContactShowDto> advertisementDtos, ArrayList<Contact> contacts, int i) {
        if (contacts.get(i).getCity() != null) {
            advertisementDtos.get(i).setContactCityName(contacts.get(i).getCity().getName());
        }
    }

    private void handleTypeUpdate(AdvertisementDto request, Advertisement advertisement) {
        Type type = typeService.getTypeBy(request.getTypeId());
        Integer adTypeId = advertisement.getType().getId();
        if (!hasSameType(adTypeId, type)) {
            advertisement.setType(type);
        }
    }

    private void handleToolUpdate(AdvertisementDto request, Advertisement advertisement) {
        Tool tool = toolService.getToolBy(request.getToolId());
        Integer adToolId = advertisement.getTool().getId();
        if (!hasSameTool(adToolId, tool)) {
            advertisement.setTool(tool);
        }
    }

    private void handleCityUpdate(AdvertisementDto request, Advertisement advertisement) {
        if (requestHasCity(request.getCityId())) {
            City city = cityService.getCityBy(request.getCityId());
            Integer adCityId = advertisement.getCity().getId();
            if (!hasSameCity(adCityId, city)) {
                advertisement.setCity(city);
            }
        }
    }

    private void handleCountyUpdate(AdvertisementDto request, Advertisement advertisement) {
        County county = countyService.getCountyBy(request.getCountyId());
        Integer adCountyId = advertisement.getCounty().getId();
        if (!hasSameCounty(adCountyId, county)) {
            advertisement.setCounty(county);
        }
    }

    private void handleCoordinateUpdate(AdvertisementDto request, Advertisement advertisement) {
        Coordinate adCoordinates = advertisement.getCoordinate();

        if (!hasCoordinates(request)) {
            return;
        }
        if (requestHasNewCoordinates(request, adCoordinates)) {
            Coordinate coordinate = createSetAndSaveCoordinate(request);
            advertisement.setCoordinate(coordinate);
        } else if (requestHasNewDifferentCoordinate(request, adCoordinates)){
            Coordinate coordinate = coordinateService.getCoordinateBy(request.getCoordinateLongField(), request.getCoordinateLat());
            coordinate.setLongField(request.getCoordinateLongField());
            coordinate.setLat(request.getCoordinateLat());
            advertisement.setCoordinate(coordinate);
        }
    }

    private static boolean requestHasNewDifferentCoordinate(AdvertisementDto request, Coordinate adCoordinates) {
        return !request.getCoordinateLat().equals(adCoordinates.getLat()) || 
                !request.getCoordinateLongField().equals(adCoordinates.getLongField());
    }

    private Coordinate createSetAndSaveCoordinate(AdvertisementDto request) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLongField(request.getCoordinateLongField());
        coordinate.setLat(request.getCoordinateLat());
        coordinateService.saveCoordinate(coordinate);
        return coordinate;
    }

    private static boolean requestHasNewCoordinates(AdvertisementDto request, Coordinate adCoordinates) {
        return hasCoordinates(request) && adCoordinates == null;
    }

    private static boolean hasCoordinates(AdvertisementDto request) {
        return request.getCoordinateLongField() == null && request.getCoordinateLat() == null;
    }

    private static boolean hasSameType(Integer adTypeId, Type type) {
        return adTypeId.equals(type.getId());
    }

    private static boolean hasSameTool(Integer adToolId, Tool tool) {
        return adToolId.equals(tool.getId());
    }

    private static boolean hasSameCity(Integer adCityId, City city) {
        return adCityId.equals(city.getId());
    }

    private static boolean hasSameCounty(Integer adCountyId, County county) {
        return adCountyId.equals(county.getId());
    }
}
