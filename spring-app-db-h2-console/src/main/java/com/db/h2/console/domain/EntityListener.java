package com.db.h2.console.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


public class EntityListener {
    //Logger logger = LoggerFactory.getLogger(EntityListener.class);

    public EntityListener() {
    }

//    public String getCurrentLogin() {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Authentication authentication = securityContext.getAuthentication();
//        UserDetails springSecurityUser = null;
//        String userName = null;
//        if (authentication != null) {
//            if (authentication.getPrincipal() instanceof UserDetails) {
//                springSecurityUser = (UserDetails)authentication.getPrincipal();
//                userName = springSecurityUser.getUsername();
//                if (userName.contains(".")) {
//                    userName = userName.substring(0, userName.indexOf("."));
//                }
//            } else if (authentication.getPrincipal() instanceof String) {
//                userName = (String)authentication.getPrincipal();
//            }
//        }
//
//        return userName;
//    }

    @PrePersist
    protected void updateCreationData(BaseEntity entity) {
        this.updateMutationData(entity);
        entity.setCreatedDate(LocalDateTime.now());
//        String mutUser = this.getCurrentLogin();
//        if (mutUser == null) {
//            //this.logger.warn("Cannot read current user, setting mutation-user to 'unknown'");
//            mutUser = "unknown";
//        }

        //entity.setCreatedBy(mutUser);
    }

    @PreUpdate
    protected void updateMutationData(BaseEntity entity) {
        entity.setModifiedDate(LocalDateTime.now());
//        String mutUser = this.getCurrentLogin();
//        if (mutUser == null) {
//            //this.logger.warn("Cannot read current user, setting mutation-user to 'unknown'");
//            mutUser = "unknown";
//        }

        //entity.setModifiedBy(mutUser);
    }
}

