package SearchFunctionality;

import java.util.HashMap;

public class SearchFunctionality {
    private HashMap<String, Integer> citiesMap;
    String cities;
    public SearchFunctionality() {
        citiesMap = new HashMap<>();

        cities = "Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London, Bangkok, Hong Kong, Dubai, Rome, Istanbul";
        String[] citiesList = cities.split(", ");

        for (String city : citiesList) {
            citiesMap.put(city, 1);
        }
    }

    public String search(String input) {
        if (input.length() < 2) {
            if (input.equals("*"))
                return cities;
            else
                return null;
        }

        StringBuilder matchingCities = new StringBuilder();
        for (String cityName : citiesMap.keySet()) {
            if (cityName.toLowerCase().startsWith(input.toLowerCase()) || cityName.toLowerCase().contains(input.toLowerCase())) {
                matchingCities.append(cityName).append(" ");
            }

        }

        return matchingCities.toString().trim();
    }
}
