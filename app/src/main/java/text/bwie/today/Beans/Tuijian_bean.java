package text.bwie.today.Beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yufuhao on 2017/5/16.
 */

public class Tuijian_bean {

    private int feed_flag;
    private boolean has_more;
    private boolean has_more_to_refresh;
    private int login_status;
    private String message;
    private String post_content_hint;
    private int show_et_status;
    private TipsBean tips;
    private int total_number;
    private List<DataBean> data;

    public int getFeed_flag() {
        return feed_flag;
    }

    public void setFeed_flag(int feed_flag) {
        this.feed_flag = feed_flag;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public boolean isHas_more_to_refresh() {
        return has_more_to_refresh;
    }

    public void setHas_more_to_refresh(boolean has_more_to_refresh) {
        this.has_more_to_refresh = has_more_to_refresh;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPost_content_hint() {
        return post_content_hint;
    }

    public void setPost_content_hint(String post_content_hint) {
        this.post_content_hint = post_content_hint;
    }

    public int getShow_et_status() {
        return show_et_status;
    }

    public void setShow_et_status(int show_et_status) {
        this.show_et_status = show_et_status;
    }

    public TipsBean getTips() {
        return tips;
    }

    public void setTips(TipsBean tips) {
        this.tips = tips;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TipsBean {
        /**
         * app_name : 今日头条
         * display_duration : 2
         * display_info : 今日头条推荐引擎有8条更新
         * display_template : 今日头条推荐引擎有%s条更新
         * download_url :
         * open_url :
         * package_name :
         * type : app
         * web_url :
         */

        private String app_name;
        private int display_duration;
        private String display_info;
        private String display_template;
        private String download_url;
        private String open_url;
        private String package_name;
        private String type;
        private String web_url;

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public int getDisplay_duration() {
            return display_duration;
        }

        public void setDisplay_duration(int display_duration) {
            this.display_duration = display_duration;
        }

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public String getDisplay_template() {
            return display_template;
        }

        public void setDisplay_template(String display_template) {
            this.display_template = display_template;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getOpen_url() {
            return open_url;
        }

        public void setOpen_url(String open_url) {
            this.open_url = open_url;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }

    public static class DataBean {
        /**
         * abstract : 合法化的公路战神 奔驰CLA45对比宝马M2现如今改装车在国内算是灰色地带，但是越来越多的人为了追求更高的性能，铤而走险改装自己的爱车，随之而来的就是厂商不断的在原有车型上推出高性能版车型，来满足这些需要大马力的车友们，合法化的公路战神就此应运而出。
         * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
         * aggr_type : 1
         * article_sub_type : 0
         * article_type : 0
         * article_url : http://toutiao.com/group/6420935365976293633/
         * ban_comment : 0
         * behot_time : 1494997244
         * bury_count : 0
         * cell_flag : 11
         * cell_layout_style : 1
         * cell_type : 0
         * comment_count : 0
         * cursor : 1494997244998
         * digg_count : 0
         * display_url : http://toutiao.com/group/6420935365976293633/
         * filter_words : [{"id":"8:0","is_selected":false,"name":"重复、旧闻"},{"id":"9:1","is_selected":false,"name":"内容质量差"},{"id":"5:394711006","is_selected":false,"name":"来源:途途试道"},{"id":"2:264323874","is_selected":false,"name":"豪华车"},{"id":"6:1612569","is_selected":false,"name":"德国品牌"},{"id":"6:17301","is_selected":false,"name":"奔驰"}]
         * forward_info : {"forward_count":0}
         * gallary_image_count : 12
         * group_id : 6420935365976293000
         * has_image : true
         * has_m3u8_video : 0
         * has_mp4_video : 0
         * has_video : false
         * hot : 0
         * ignore_web_transform : 1
         * image_list : [{"height":562,"uri":"list/21320000b8c3429a621d","url":"http://p1.pstatp.com/list/21320000b8c3429a621d","url_list":[{"url":"http://p1.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb3.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb9.pstatp.com/list/21320000b8c3429a621d"}],"width":1000},{"height":562,"uri":"list/21340004610c6c1224a0","url":"http://p1.pstatp.com/list/21340004610c6c1224a0","url_list":[{"url":"http://p1.pstatp.com/list/21340004610c6c1224a0"},{"url":"http://pb3.pstatp.com/list/21340004610c6c1224a0"},{"url":"http://pb9.pstatp.com/list/21340004610c6c1224a0"}],"width":1000},{"height":562,"uri":"list/1f8d0004602e89fba55d","url":"http://p3.pstatp.com/list/1f8d0004602e89fba55d","url_list":[{"url":"http://p3.pstatp.com/list/1f8d0004602e89fba55d"},{"url":"http://pb9.pstatp.com/list/1f8d0004602e89fba55d"},{"url":"http://pb1.pstatp.com/list/1f8d0004602e89fba55d"}],"width":1000}]
         * is_subject : false
         * item_id : 6420937641616737000
         * item_version : 0
         * keywords : 宝马M2,涡轮增压发动机,CLA45,奔驰CLA45,合法化,高性能,宝马
         * large_image_list : []
         * level : 0
         * log_pb : {"impr_id":"20170517130044010004027147241A03"}
         * media_info : {"avatar_url":"http://p2.pstatp.com/large/14f001266f4fb5b7337","follow":false,"is_star_user":false,"media_id":6028915039,"name":"途途试道","recommend_reason":"","recommend_type":0,"user_id":6026153961,"user_verified":false,"verified_content":""}
         * media_name : 途途试道
         * middle_image : {"height":562,"uri":"list/21320000b8c3429a621d","url":"http://p1.pstatp.com/list/21320000b8c3429a621d","url_list":[{"url":"http://p1.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb3.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb9.pstatp.com/list/21320000b8c3429a621d"}],"width":1000}
         * preload_web : 1
         * publish_time : 1494991044
         * read_count : 0
         * rid : 20170517130044010004027147241A03
         * share_url : http://toutiao.com/a6420935365976293633/?iid=3642583580&app=news_article
         * show_portrait : false
         * show_portrait_article : false
         * source : 途途试道
         * source_icon_style : 4
         * source_open_url : sslocal://profile?uid=6026153961
         * tag : news_car
         * tag_id : 6420935365976293000
         * tip : 0
         * title : 合法化的公路战神 奔驰CLA45对比宝马M2
         * url : http://toutiao.com/group/6420935365976293633/
         * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/14f001266f4fb5b7337","description":"一站式汽车动态体验平台","follow":false,"follower_count":0,"name":"途途试道","user_auth_info":"","user_id":6026153961,"user_verified":false,"verified_content":""}
         * user_repin : 0
         * user_verified : 0
         * verified_content :
         * video_style : 0
         */

        @SerializedName("abstract")
        private String abstractX;
        private int aggr_type;
        private int article_sub_type;
        private int article_type;
        private String article_url;
        private int ban_comment;
        private int behot_time;
        private int bury_count;
        private int cell_flag;
        private int cell_layout_style;
        private int cell_type;
        private int comment_count;
        private long cursor;
        private int digg_count;
        private String display_url;
        private ForwardInfoBean forward_info;
        private int gallary_image_count;
        private long group_id;
        private boolean has_image;
        private int has_m3u8_video;
        private int has_mp4_video;
        private boolean has_video;
        private int hot;
        private int ignore_web_transform;
        private boolean is_subject;
        private long item_id;
        private int item_version;
        private String keywords;
        private int level;
        private LogPbBean log_pb;
        private MediaInfoBean media_info;
        private String media_name;
        private MiddleImageBean middle_image;
        private int preload_web;
        private int publish_time;
        private int read_count;
        private String rid;
        private String share_url;
        private boolean show_portrait;
        private boolean show_portrait_article;
        private String source;
        private int source_icon_style;
        private String source_open_url;
        private String tag;
        private long tag_id;
        private int tip;
        private String title;
        private String url;
        private UserInfoBean user_info;
        private int user_repin;
        private int user_verified;
        private String verified_content;
        private int video_style;
        private List<ActionListBean> action_list;
        private List<FilterWordsBean> filter_words;
        private List<ImageListBean> image_list;
        private List<?> large_image_list;

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public int getAggr_type() {
            return aggr_type;
        }

        public void setAggr_type(int aggr_type) {
            this.aggr_type = aggr_type;
        }

        public int getArticle_sub_type() {
            return article_sub_type;
        }

        public void setArticle_sub_type(int article_sub_type) {
            this.article_sub_type = article_sub_type;
        }

        public int getArticle_type() {
            return article_type;
        }

        public void setArticle_type(int article_type) {
            this.article_type = article_type;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public int getBan_comment() {
            return ban_comment;
        }

        public void setBan_comment(int ban_comment) {
            this.ban_comment = ban_comment;
        }

        public int getBehot_time() {
            return behot_time;
        }

        public void setBehot_time(int behot_time) {
            this.behot_time = behot_time;
        }

        public int getBury_count() {
            return bury_count;
        }

        public void setBury_count(int bury_count) {
            this.bury_count = bury_count;
        }

        public int getCell_flag() {
            return cell_flag;
        }

        public void setCell_flag(int cell_flag) {
            this.cell_flag = cell_flag;
        }

        public int getCell_layout_style() {
            return cell_layout_style;
        }

        public void setCell_layout_style(int cell_layout_style) {
            this.cell_layout_style = cell_layout_style;
        }

        public int getCell_type() {
            return cell_type;
        }

        public void setCell_type(int cell_type) {
            this.cell_type = cell_type;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public long getCursor() {
            return cursor;
        }

        public void setCursor(long cursor) {
            this.cursor = cursor;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public String getDisplay_url() {
            return display_url;
        }

        public void setDisplay_url(String display_url) {
            this.display_url = display_url;
        }

        public ForwardInfoBean getForward_info() {
            return forward_info;
        }

        public void setForward_info(ForwardInfoBean forward_info) {
            this.forward_info = forward_info;
        }

        public int getGallary_image_count() {
            return gallary_image_count;
        }

        public void setGallary_image_count(int gallary_image_count) {
            this.gallary_image_count = gallary_image_count;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public boolean isHas_image() {
            return has_image;
        }

        public void setHas_image(boolean has_image) {
            this.has_image = has_image;
        }

        public int getHas_m3u8_video() {
            return has_m3u8_video;
        }

        public void setHas_m3u8_video(int has_m3u8_video) {
            this.has_m3u8_video = has_m3u8_video;
        }

        public int getHas_mp4_video() {
            return has_mp4_video;
        }

        public void setHas_mp4_video(int has_mp4_video) {
            this.has_mp4_video = has_mp4_video;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getIgnore_web_transform() {
            return ignore_web_transform;
        }

        public void setIgnore_web_transform(int ignore_web_transform) {
            this.ignore_web_transform = ignore_web_transform;
        }

        public boolean isIs_subject() {
            return is_subject;
        }

        public void setIs_subject(boolean is_subject) {
            this.is_subject = is_subject;
        }

        public long getItem_id() {
            return item_id;
        }

        public void setItem_id(long item_id) {
            this.item_id = item_id;
        }

        public int getItem_version() {
            return item_version;
        }

        public void setItem_version(int item_version) {
            this.item_version = item_version;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public LogPbBean getLog_pb() {
            return log_pb;
        }

        public void setLog_pb(LogPbBean log_pb) {
            this.log_pb = log_pb;
        }

        public MediaInfoBean getMedia_info() {
            return media_info;
        }

        public void setMedia_info(MediaInfoBean media_info) {
            this.media_info = media_info;
        }

        public String getMedia_name() {
            return media_name;
        }

        public void setMedia_name(String media_name) {
            this.media_name = media_name;
        }

        public MiddleImageBean getMiddle_image() {
            return middle_image;
        }

        public void setMiddle_image(MiddleImageBean middle_image) {
            this.middle_image = middle_image;
        }

        public int getPreload_web() {
            return preload_web;
        }

        public void setPreload_web(int preload_web) {
            this.preload_web = preload_web;
        }

        public int getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(int publish_time) {
            this.publish_time = publish_time;
        }

        public int getRead_count() {
            return read_count;
        }

        public void setRead_count(int read_count) {
            this.read_count = read_count;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public boolean isShow_portrait() {
            return show_portrait;
        }

        public void setShow_portrait(boolean show_portrait) {
            this.show_portrait = show_portrait;
        }

        public boolean isShow_portrait_article() {
            return show_portrait_article;
        }

        public void setShow_portrait_article(boolean show_portrait_article) {
            this.show_portrait_article = show_portrait_article;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getSource_icon_style() {
            return source_icon_style;
        }

        public void setSource_icon_style(int source_icon_style) {
            this.source_icon_style = source_icon_style;
        }

        public String getSource_open_url() {
            return source_open_url;
        }

        public void setSource_open_url(String source_open_url) {
            this.source_open_url = source_open_url;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public long getTag_id() {
            return tag_id;
        }

        public void setTag_id(long tag_id) {
            this.tag_id = tag_id;
        }

        public int getTip() {
            return tip;
        }

        public void setTip(int tip) {
            this.tip = tip;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public int getUser_repin() {
            return user_repin;
        }

        public void setUser_repin(int user_repin) {
            this.user_repin = user_repin;
        }

        public int getUser_verified() {
            return user_verified;
        }

        public void setUser_verified(int user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public int getVideo_style() {
            return video_style;
        }

        public void setVideo_style(int video_style) {
            this.video_style = video_style;
        }

        public List<ActionListBean> getAction_list() {
            return action_list;
        }

        public void setAction_list(List<ActionListBean> action_list) {
            this.action_list = action_list;
        }

        public List<FilterWordsBean> getFilter_words() {
            return filter_words;
        }

        public void setFilter_words(List<FilterWordsBean> filter_words) {
            this.filter_words = filter_words;
        }

        public List<ImageListBean> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<ImageListBean> image_list) {
            this.image_list = image_list;
        }

        public List<?> getLarge_image_list() {
            return large_image_list;
        }

        public void setLarge_image_list(List<?> large_image_list) {
            this.large_image_list = large_image_list;
        }

        public static class ForwardInfoBean {
            /**
             * forward_count : 0
             */

            private int forward_count;

            public int getForward_count() {
                return forward_count;
            }

            public void setForward_count(int forward_count) {
                this.forward_count = forward_count;
            }
        }

        public static class LogPbBean {
            /**
             * impr_id : 20170517130044010004027147241A03
             */

            private String impr_id;

            public String getImpr_id() {
                return impr_id;
            }

            public void setImpr_id(String impr_id) {
                this.impr_id = impr_id;
            }
        }

        public static class MediaInfoBean {
            /**
             * avatar_url : http://p2.pstatp.com/large/14f001266f4fb5b7337
             * follow : false
             * is_star_user : false
             * media_id : 6028915039
             * name : 途途试道
             * recommend_reason :
             * recommend_type : 0
             * user_id : 6026153961
             * user_verified : false
             * verified_content :
             */

            private String avatar_url;
            private boolean follow;
            private boolean is_star_user;
            private long media_id;
            private String name;
            private String recommend_reason;
            private int recommend_type;
            private long user_id;
            private boolean user_verified;
            private String verified_content;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public boolean isIs_star_user() {
                return is_star_user;
            }

            public void setIs_star_user(boolean is_star_user) {
                this.is_star_user = is_star_user;
            }

            public long getMedia_id() {
                return media_id;
            }

            public void setMedia_id(long media_id) {
                this.media_id = media_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRecommend_reason() {
                return recommend_reason;
            }

            public void setRecommend_reason(String recommend_reason) {
                this.recommend_reason = recommend_reason;
            }

            public int getRecommend_type() {
                return recommend_type;
            }

            public void setRecommend_type(int recommend_type) {
                this.recommend_type = recommend_type;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public String getVerified_content() {
                return verified_content;
            }

            public void setVerified_content(String verified_content) {
                this.verified_content = verified_content;
            }
        }

        public static class MiddleImageBean {
            /**
             * height : 562
             * uri : list/21320000b8c3429a621d
             * url : http://p1.pstatp.com/list/21320000b8c3429a621d
             * url_list : [{"url":"http://p1.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb3.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb9.pstatp.com/list/21320000b8c3429a621d"}]
             * width : 1000
             */

            private int height;
            private String uri;
            private String url;
            private int width;
            private List<UrlListBean> url_list;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<UrlListBean> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBean> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBean {
                /**
                 * url : http://p1.pstatp.com/list/21320000b8c3429a621d
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class UserInfoBean {
            /**
             * avatar_url : http://p3.pstatp.com/thumb/14f001266f4fb5b7337
             * description : 一站式汽车动态体验平台
             * follow : false
             * follower_count : 0
             * name : 途途试道
             * user_auth_info :
             * user_id : 6026153961
             * user_verified : false
             * verified_content :
             */

            private String avatar_url;
            private String description;
            private boolean follow;
            private int follower_count;
            private String name;
            private String user_auth_info;
            private long user_id;
            private boolean user_verified;
            private String verified_content;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public int getFollower_count() {
                return follower_count;
            }

            public void setFollower_count(int follower_count) {
                this.follower_count = follower_count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(String user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public String getVerified_content() {
                return verified_content;
            }

            public void setVerified_content(String verified_content) {
                this.verified_content = verified_content;
            }
        }

        public static class ActionListBean {
            /**
             * action : 1
             * desc :
             * extra : {}
             */

            private int action;
            private String desc;
            private ExtraBean extra;

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public static class ExtraBean {
            }
        }

        public static class FilterWordsBean {
            /**
             * id : 8:0
             * is_selected : false
             * name : 重复、旧闻
             */

            private String id;
            private boolean is_selected;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIs_selected() {
                return is_selected;
            }

            public void setIs_selected(boolean is_selected) {
                this.is_selected = is_selected;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ImageListBean {
            /**
             * height : 562
             * uri : list/21320000b8c3429a621d
             * url : http://p1.pstatp.com/list/21320000b8c3429a621d
             * url_list : [{"url":"http://p1.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb3.pstatp.com/list/21320000b8c3429a621d"},{"url":"http://pb9.pstatp.com/list/21320000b8c3429a621d"}]
             * width : 1000
             */

            private int height;
            private String uri;
            private String url;
            private int width;
            private List<UrlListBeanX> url_list;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<UrlListBeanX> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBeanX> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBeanX {
                /**
                 * url : http://p1.pstatp.com/list/21320000b8c3429a621d
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
