package com.base.util.constants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class Constants {

    private Constants() {
    }

    /**
     * Common
     */
    public static final String MSG_DONE = "Done";

    public static final String MSG_USER_NOT_FOUND = "User not found";

    public static final String MSG_INVALID_PARAMS = "Invalid parameter";

    public static final String MSG_MAX_LIMIT_FRIEND = "User has reached friend limit";

    public static final String MSG_MAX_LIMIT_PARTY = "Party has reached member limit";

    public static final String MSG_INVALID_ID = "Invalid ID";

    public static final String MSG_TOKEN_NOT_FOUND = "Token is not exist";

    public static final String MSG_TOKEN_IS_EXIST = "Token is exist";

    public static final String MSG_TOKEN_IS_RESET = "token is reset";

    public static final String MSG_TOKEN_IS_INVALID = "Token is invalid";

    public static final String MSG_WALLET_ADDRESS_INVALID = "Wallet address is invalid";

    public static final String MSG_USER_IS_EXIST = "User is exist";

    public static final String MSG_SYSTEM_ERROR = "Have error of system";

    public static final String MSG_USER_IS_NOT_EXIST = "User is not exist";

    public static final String MSG_NO_TOKEN = "No token provided!";

    public static final String MSG_UNAUTHORIZED = "Unauthorized!";

    public static final String GUEST_LOGIN = "guest_login";

    public static final String MSG_NOT_PERMISSION = "User don't have permission";

    public static final String MSG_INVALID_MESSAGE = "Invalid message";

    public static final String MSG_NOT_ENOUGH_POINTS = "Not enough points";

    public static final String AVATAR_PART_NOT_FOUND = "avatar part is not found";

    public static final String MSG_NFT_NOT_FOUND = "Nft not found";

    public static final String MSG_USER_SETTING_NOT_FOUND = "User setting not found";

    public static final String MSG_EMAIL_INVALID_FORMAT = "Email is invalid format";
    public static final String MSG_USER_IS_BLOCKED = "Your account has been blocked!";
    public static final String MSG_USER_IS_INACTIVE = "Your account is inactive!";

    /**
     * ERROR CODE
     */
    public static final String ERR_USER_BLOCKED = "ERR_USER_BLOCKED";
    public static final String ERR_USER_INACTIVE = "ERR_USER_INACTIVE";

    /**
     * SORT
     */
    public static final String SORT_COLUMN_ID = "id";
    public static final String SORT_COLUMN_TOKEN_ID = "tokenId";
    public static final String SORT_TYPE_DESC = "DESC";
    public static final String SORT_TYPE_ASC = "ASC";
    public static final String RELATED_EVENT_SIZE = "3";

    public static final String MSG_WALLET_ADDRESS_NOT_FOUND = "Public address or wallet is not found.";

    /**
     * Friend
     */
    // status message
    public static final Integer NOT_SEEN = 0;
    public static final Integer SEEN = 1;

    // status friend
    public static final Integer FRIEND = 0;
    public static final Integer CANCELED = 1;

    // status friend request
    public static final Integer SENT = 0;
    public static final Integer ACCEPTED = 1;
    public static final Integer REJECTED = 2;

    /**
     * Pattern
     */
    public static final Pattern PATTERN_EMAIL = Pattern.compile("^(.+)@(.+)$");
    public static final Pattern IGNORE_CASE_ADDRESS_PATTERN = Pattern.compile("(?i)^(0x)?[0-9a-f]{40}$");
    public static final Pattern LOWER_CASE_ADDRESS_PATTERN = Pattern.compile("^(0x)?[0-9a-f]{40}$");
    public static final Pattern UPPER_CASE_ADDRESS_PATTERN = Pattern.compile("^(0x)?[0-9A-F]{40}$");
    /**
     * Range
     */
    public static final Integer MIN = 10000000;
    public static final Integer MAX = 99999999;
    public static final Integer DEFAULT_LIMIT_MEMBERS = 100;
    public static final Integer DEFAULT_LIMIT_FRIEND = 100;

    /**
     * Character
     */
    public static final String SLASH = "/";

    public static final String DOT = ".";
    public static final String UNDERSCORE = "_";

    /**
     * Aws
     */
    public static final String HTTPS_STRING = "https://";
    public static final String HTTP_STRING = "http://";
    public static final String AWS_BOOTHS_IMAGE_FOLDER = "images/booths/";
    public static final String AWS_ADVERTISEMENTS_IMAGE_FOLDER = "images/advertisements/";
    public static final String AWS_ADVERTISEMENTS_VIDEO_FOLDER = "videos/advertisements/";
    public static final String AWS_EVENTS_IMAGE_FOLDER = "images/events/";

    public static final String AVATARS_IMAGE_FOLDER = "images/avatars/";

    public static final String ITEM_CATEGORY_IMAGE_FOLDER = "images/item_category/";

    /**
     * AuthServer - SSO
     */
    public static final String AUTH_ATTRIBUTE_WEB3SESSION = "attr.%s.web3.session";

    /**
     * User_parties
     */
    public static final long PARTY_LIMIT = 20;

    /**
     * User_Floors
     */
    public static final long FLOOR_LIMIT = 20;

    /**
     * User notification
     */
    // status
    public static final Boolean IS_NOT_SEEN = false;
    public static final Boolean IS_SEEN = true;

    /**
     * Regex
     */
    public static final String EMAIL_PATTERN = "^(.+)@(.+)$";
    public static final String REPLACE_CHAR = "%s";

    /**
     * Email
     */
    public static final String EMAIL_SEND_FROM_NAME = "MCC";

    /**
     * Survey
     */
    public static final String MSG_SURVEY_NOT_FOUND = "Survey not found";
    public static final String MSG_SURVEY_FIELD_NOT_FOUND = "Survey field not found";

    public static final List<String> WHITE_LIST_ACCESS_INACTIVE = Arrays.asList("/api/v1/auth/request-verify");

}
