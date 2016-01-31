package com.app.everyday.models;

import java.io.Serializable;
import java.util.List;

/**
 * Author：YJQ on 2016/1/13 17:45
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class TopicModel implements Serializable{

    /**
     * status : 0
     * result : [{"voteUsers":[],"post":{"postId":13927,"media":[{"mimeType":"text/plain","value":"虽然我皮肤不好 但不喜太厚底妆 MAC粉细簿 隔离 BB霜后可控油 换了几次芯 hera冬天必用 CDP隔离顺滑调肤色 都值得再购"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/Fn8kY9KuPCmZEWDZpoqxBAEFSBpz"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/FoPQy2-n2EB2Flnrvg3fX9fvlYro"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/FrfOsn5uC40QI04P8OVzotXYJkDP"}],"priority":0,"createdTime":1452676275000,"postStats":{"read":5,"like":0,"dislike":0,"comment":0,"share":0},"content":null,"imageUrls":[],"weblink":"http://www.meitianapp.com/wap/post/13927"},"activity":{"activityId":"9126659d-82bc-4484-9c54-c0daadc14034","title":"那些年我们追过的粉底","summary":"神马是最好的粉底？就是明明涂了厚厚的一层，但是被直男狂赞：你素颜真好看啊！","prize":"小每砸吻么么哒","ruleUrl":"http://www.meitianapp.com/app/activity/rule/9126659d-82bc-4484-9c54-c0daadc14034","image":"http://7xj9d8.com2.z0.glb.qiniucdn.com/o_1a8q79di1l4dljchc1ngj1sj47.jpg","backgroundImage":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/activity/bg_image/activity_green.png","color":"#00DEBD","startTime":1452528000000,"stopTime":1453305540000,"activityStats":{"read":8,"create":4,"like":2,"dislike":0,"comment":0,"share":0,"participator":6},"prioritized":false},"user":{"userId":"16b0082e-1c26-32b6-9191-8a98475f8a9f","nickname":null,"avatar":null,"gender":0,"loginType":1,"loginId":"o2aNjs-b0r6YAso49q-KGfZfFfyA","loginNickname":"沅臻","loginAvatar":"http://wx.qlogo.cn/mmopen/50HcP4UOeLUyA7tPvCJaZ2rF0HYyUvibFuxOSFqMficZFEgMvXKKxWtyWAywItPmNprdahibpmib4TMAnHt9Fhs6BQ/0","loginGender":1},"sequenceId":"13927"}]
     * next : 13924
     */

    private int status;
    private String next;
    /**
     * voteUsers : []
     * post : {"postId":13927,"media":[{"mimeType":"text/plain","value":"虽然我皮肤不好 但不喜太厚底妆 MAC粉细簿 隔离 BB霜后可控油 换了几次芯 hera冬天必用 CDP隔离顺滑调肤色 都值得再购"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/Fn8kY9KuPCmZEWDZpoqxBAEFSBpz"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/FoPQy2-n2EB2Flnrvg3fX9fvlYro"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/FrfOsn5uC40QI04P8OVzotXYJkDP"}],"priority":0,"createdTime":1452676275000,"postStats":{"read":5,"like":0,"dislike":0,"comment":0,"share":0},"content":null,"imageUrls":[],"weblink":"http://www.meitianapp.com/wap/post/13927"}
     * activity : {"activityId":"9126659d-82bc-4484-9c54-c0daadc14034","title":"那些年我们追过的粉底","summary":"神马是最好的粉底？就是明明涂了厚厚的一层，但是被直男狂赞：你素颜真好看啊！","prize":"小每砸吻么么哒","ruleUrl":"http://www.meitianapp.com/app/activity/rule/9126659d-82bc-4484-9c54-c0daadc14034","image":"http://7xj9d8.com2.z0.glb.qiniucdn.com/o_1a8q79di1l4dljchc1ngj1sj47.jpg","backgroundImage":"http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/activity/bg_image/activity_green.png","color":"#00DEBD","startTime":1452528000000,"stopTime":1453305540000,"activityStats":{"read":8,"create":4,"like":2,"dislike":0,"comment":0,"share":0,"participator":6},"prioritized":false}
     * user : {"userId":"16b0082e-1c26-32b6-9191-8a98475f8a9f","nickname":null,"avatar":null,"gender":0,"loginType":1,"loginId":"o2aNjs-b0r6YAso49q-KGfZfFfyA","loginNickname":"沅臻","loginAvatar":"http://wx.qlogo.cn/mmopen/50HcP4UOeLUyA7tPvCJaZ2rF0HYyUvibFuxOSFqMficZFEgMvXKKxWtyWAywItPmNprdahibpmib4TMAnHt9Fhs6BQ/0","loginGender":1}
     * sequenceId : 13927
     */

    private List<ResultEntity> result;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public String getNext() {
        return next;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        /**
         * postId : 13927
         * media : [{"mimeType":"text/plain","value":"虽然我皮肤不好 但不喜太厚底妆 MAC粉细簿 隔离 BB霜后可控油 换了几次芯 hera冬天必用 CDP隔离顺滑调肤色 都值得再购"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/Fn8kY9KuPCmZEWDZpoqxBAEFSBpz"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/FoPQy2-n2EB2Flnrvg3fX9fvlYro"},{"mimeType":"image/jpeg","originalUrl":"http://7xla0h.com2.z0.glb.qiniucdn.com/FrfOsn5uC40QI04P8OVzotXYJkDP"}]
         * priority : 0
         * createdTime : 1452676275000
         * postStats : {"read":5,"like":0,"dislike":0,"comment":0,"share":0}
         * content : null
         * imageUrls : []
         * weblink : http://www.meitianapp.com/wap/post/13927
         */

        private PostEntity post;
        /**
         * activityId : 9126659d-82bc-4484-9c54-c0daadc14034
         * title : 那些年我们追过的粉底
         * summary : 神马是最好的粉底？就是明明涂了厚厚的一层，但是被直男狂赞：你素颜真好看啊！
         * prize : 小每砸吻么么哒
         * ruleUrl : http://www.meitianapp.com/app/activity/rule/9126659d-82bc-4484-9c54-c0daadc14034
         * image : http://7xj9d8.com2.z0.glb.qiniucdn.com/o_1a8q79di1l4dljchc1ngj1sj47.jpg
         * backgroundImage : http://7xizes.com2.z0.glb.qiniucdn.com/@/v1/activity/bg_image/activity_green.png
         * color : #00DEBD
         * startTime : 1452528000000
         * stopTime : 1453305540000
         * activityStats : {"read":8,"create":4,"like":2,"dislike":0,"comment":0,"share":0,"participator":6}
         * prioritized : false
         */

        private ActivityEntity activity;
        /**
         * userId : 16b0082e-1c26-32b6-9191-8a98475f8a9f
         * nickname : null
         * avatar : null
         * gender : 0
         * loginType : 1
         * loginId : o2aNjs-b0r6YAso49q-KGfZfFfyA
         * loginNickname : 沅臻
         * loginAvatar : http://wx.qlogo.cn/mmopen/50HcP4UOeLUyA7tPvCJaZ2rF0HYyUvibFuxOSFqMficZFEgMvXKKxWtyWAywItPmNprdahibpmib4TMAnHt9Fhs6BQ/0
         * loginGender : 1
         */

        private UserEntity user;
        private String sequenceId;
        private List<?> voteUsers;

        public void setPost(PostEntity post) {
            this.post = post;
        }

        public void setActivity(ActivityEntity activity) {
            this.activity = activity;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setSequenceId(String sequenceId) {
            this.sequenceId = sequenceId;
        }

        public void setVoteUsers(List<?> voteUsers) {
            this.voteUsers = voteUsers;
        }

        public PostEntity getPost() {
            return post;
        }

        public ActivityEntity getActivity() {
            return activity;
        }

        public UserEntity getUser() {
            return user;
        }

        public String getSequenceId() {
            return sequenceId;
        }

        public List<?> getVoteUsers() {
            return voteUsers;
        }

        public static class PostEntity {
            private int postId;
            private int priority;
            private long createdTime;
            /**
             * read : 5
             * like : 0
             * dislike : 0
             * comment : 0
             * share : 0
             */

            private PostStatsEntity postStats;
            private Object content;
            private String weblink;
            /**
             * mimeType : text/plain
             * value : 虽然我皮肤不好 但不喜太厚底妆 MAC粉细簿 隔离 BB霜后可控油 换了几次芯 hera冬天必用 CDP隔离顺滑调肤色 都值得再购
             */

            private List<MediaEntity> media;
            private List<?> imageUrls;

            public void setPostId(int postId) {
                this.postId = postId;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public void setCreatedTime(long createdTime) {
                this.createdTime = createdTime;
            }

            public void setPostStats(PostStatsEntity postStats) {
                this.postStats = postStats;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public void setWeblink(String weblink) {
                this.weblink = weblink;
            }

            public void setMedia(List<MediaEntity> media) {
                this.media = media;
            }

            public void setImageUrls(List<?> imageUrls) {
                this.imageUrls = imageUrls;
            }

            public int getPostId() {
                return postId;
            }

            public int getPriority() {
                return priority;
            }

            public long getCreatedTime() {
                return createdTime;
            }

            public PostStatsEntity getPostStats() {
                return postStats;
            }

            public Object getContent() {
                return content;
            }

            public String getWeblink() {
                return weblink;
            }

            public List<MediaEntity> getMedia() {
                return media;
            }

            public List<?> getImageUrls() {
                return imageUrls;
            }

            public static class PostStatsEntity {
                private int read;
                private int like;
                private int dislike;
                private int comment;
                private int share;

                public void setRead(int read) {
                    this.read = read;
                }

                public void setLike(int like) {
                    this.like = like;
                }

                public void setDislike(int dislike) {
                    this.dislike = dislike;
                }

                public void setComment(int comment) {
                    this.comment = comment;
                }

                public void setShare(int share) {
                    this.share = share;
                }

                public int getRead() {
                    return read;
                }

                public int getLike() {
                    return like;
                }

                public int getDislike() {
                    return dislike;
                }

                public int getComment() {
                    return comment;
                }

                public int getShare() {
                    return share;
                }
            }

            public static class MediaEntity {
                private String mimeType;
                private String value;
                private String originalUrl;

                public String getOriginalUrl() {
                    return originalUrl;
                }

                public void setOriginalUrl(String originalUrl) {
                    this.originalUrl = originalUrl;
                }

                public void setMimeType(String mimeType) {
                    this.mimeType = mimeType;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getMimeType() {
                    return mimeType;
                }

                public String getValue() {
                    return value;
                }
            }
        }

        public static class ActivityEntity {
            private String activityId;
            private String title;
            private String summary;
            private String prize;
            private String ruleUrl;
            private String image;
            private String backgroundImage;
            private String color;
            private long startTime;
            private long stopTime;
            /**
             * read : 8
             * create : 4
             * like : 2
             * dislike : 0
             * comment : 0
             * share : 0
             * participator : 6
             */

            private ActivityStatsEntity activityStats;
            private boolean prioritized;

            public void setActivityId(String activityId) {
                this.activityId = activityId;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public void setPrize(String prize) {
                this.prize = prize;
            }

            public void setRuleUrl(String ruleUrl) {
                this.ruleUrl = ruleUrl;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public void setStopTime(long stopTime) {
                this.stopTime = stopTime;
            }

            public void setActivityStats(ActivityStatsEntity activityStats) {
                this.activityStats = activityStats;
            }

            public void setPrioritized(boolean prioritized) {
                this.prioritized = prioritized;
            }

            public String getActivityId() {
                return activityId;
            }

            public String getTitle() {
                return title;
            }

            public String getSummary() {
                return summary;
            }

            public String getPrize() {
                return prize;
            }

            public String getRuleUrl() {
                return ruleUrl;
            }

            public String getImage() {
                return image;
            }

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public String getColor() {
                return color;
            }

            public long getStartTime() {
                return startTime;
            }

            public long getStopTime() {
                return stopTime;
            }

            public ActivityStatsEntity getActivityStats() {
                return activityStats;
            }

            public boolean isPrioritized() {
                return prioritized;
            }

            public static class ActivityStatsEntity {
                private int read;
                private int create;
                private int like;
                private int dislike;
                private int comment;
                private int share;
                private int participator;

                public void setRead(int read) {
                    this.read = read;
                }

                public void setCreate(int create) {
                    this.create = create;
                }

                public void setLike(int like) {
                    this.like = like;
                }

                public void setDislike(int dislike) {
                    this.dislike = dislike;
                }

                public void setComment(int comment) {
                    this.comment = comment;
                }

                public void setShare(int share) {
                    this.share = share;
                }

                public void setParticipator(int participator) {
                    this.participator = participator;
                }

                public int getRead() {
                    return read;
                }

                public int getCreate() {
                    return create;
                }

                public int getLike() {
                    return like;
                }

                public int getDislike() {
                    return dislike;
                }

                public int getComment() {
                    return comment;
                }

                public int getShare() {
                    return share;
                }

                public int getParticipator() {
                    return participator;
                }
            }
        }

        public static class UserEntity {
            private String userId;
            private Object nickname;
            private Object avatar;
            private int gender;
            private int loginType;
            private String loginId;
            private String loginNickname;
            private String loginAvatar;
            private int loginGender;

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public void setLoginType(int loginType) {
                this.loginType = loginType;
            }

            public void setLoginId(String loginId) {
                this.loginId = loginId;
            }

            public void setLoginNickname(String loginNickname) {
                this.loginNickname = loginNickname;
            }

            public void setLoginAvatar(String loginAvatar) {
                this.loginAvatar = loginAvatar;
            }

            public void setLoginGender(int loginGender) {
                this.loginGender = loginGender;
            }

            public String getUserId() {
                return userId;
            }

            public Object getNickname() {
                return nickname;
            }

            public Object getAvatar() {
                return avatar;
            }

            public int getGender() {
                return gender;
            }

            public int getLoginType() {
                return loginType;
            }

            public String getLoginId() {
                return loginId;
            }

            public String getLoginNickname() {
                return loginNickname;
            }

            public String getLoginAvatar() {
                return loginAvatar;
            }

            public int getLoginGender() {
                return loginGender;
            }
        }
    }
}
