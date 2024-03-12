package com.mozverse.mozimtestapp.data.xml

data class XMLHelper(
    val extensionAttrType: String = "moz_action_media",

    val adId: String = "adId",

    // ima node
    val imaAttrCreativeId: String = "Creative ID",

    // data node
    val dataPhoneNumber: String = "(212) 111-111",
    val smsBody: String = "A sample sms text",
    val websiteUrl: String = "https://www.example.com",

    val attrShowLocalNotification: String = "true",
    val attrDisplayContact: String = "true",
    val attrDisplayCalendar: String = "true",
    val attrDisplayImage: String = "true",

    // environment node
    val environmentAttrNameAndroid: String = "Google",
    val environmentAttrNameApple: String = "Apple",
    val appleStoreUrl1: String = "https://apps.apple.com/us/app/app-name/id1",
    val appleStoreUrl2: String = "https://apps.apple.com/us/app/app-name/id2",
    val playStoreUrl: String =
        "https://play.google.com/store/apps/details?id=com.google.android.youtube",

    // wallet
    val walletAppleUrl: String =
        "https://events-im.mozverse.com/sdk?advertiserId=116&campaignId=114&adId=231637d8-d8db-4018-8b3f-525e4dcfa690&accountId=af09c8f6-550e-4d51-ad60-58759626b068&creativeId=109",
    val walletAndroidUrl: String =
        "https://pay.google.com/gp/v/save/eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJtb3p3YWxsZXRAbW96dmVyc2UtMzkxMzE4LmlhbS5nc2VydmljZWFjY291bnQuY29tIiwiYXVkIjoiZ29vZ2xlIiwidHlwIjoic2F2ZXRvd2FsbGV0IiwicGF5bG9hZCI6eyJnZW5lcmljQ2xhc3NlcyI6W3siaWQiOiIzMzg4MDAwMDAwMDIyMjU0OTI2LmRpZ2l0YWxfY29sbGVjdGlibGVfZ2VuZXJpY192MiIsImNsYXNzVGVtcGxhdGVJbmZvIjp7ImNhcmRUZW1wbGF0ZU92ZXJyaWRlIjp7ImNhcmRSb3dUZW1wbGF0ZUluZm9zIjpbeyJ0d29JdGVtcyI6eyJzdGFydEl0ZW0iOnsiZmlyc3RWYWx1ZSI6eyJmaWVsZHMiOlt7ImZpZWxkUGF0aCI6Im9iamVjdC50ZXh0TW9kdWxlc0RhdGFbJ3Rva2VuLW5hbWUnXSJ9XX19LCJlbmRJdGVtIjp7ImZpcnN0VmFsdWUiOnsiZmllbGRzIjpbeyJmaWVsZFBhdGgiOiJvYmplY3QudGV4dE1vZHVsZXNEYXRhWyd0b2tlbi1vd25lcnNoaXAnXSJ9XX19fX0seyJ0d29JdGVtcyI6eyJzdGFydEl0ZW0iOnsiZmlyc3RWYWx1ZSI6eyJmaWVsZHMiOlt7ImZpZWxkUGF0aCI6Im9iamVjdC50ZXh0TW9kdWxlc0RhdGFbJ293bmVkLWJ5J10ifV19fSwiZW5kSXRlbSI6eyJmaXJzdFZhbHVlIjp7ImZpZWxkcyI6W3siZmllbGRQYXRoIjoib2JqZWN0LnRleHRNb2R1bGVzRGF0YVsncGFzcy1wYXNzd29yZCddIn1dfX19fV19fSwiY2FsbGJhY2tPcHRpb25zIjp7InVybCI6Imh0dHBzOi8vYXBwLWJhY2tlbmQubW96d2FsbGV0LmNvbS9hcGkvdjEvZ29vZ2xlLXdhbGxldC1jYWxsYmFja3MifX1dLCJnZW5lcmljT2JqZWN0cyI6W3siaWQiOiIzMzg4MDAwMDAwMDIyMjU0OTI2LlRWOEFYVFU5WUpDSSIsImNsYXNzSWQiOiIzMzg4MDAwMDAwMDIyMjU0OTI2LmRpZ2l0YWxfY29sbGVjdGlibGVfZ2VuZXJpY192MiIsInN0YXRlIjoiQUNUSVZFIiwibG9nbyI6eyJzb3VyY2VVcmkiOnsidXJpIjoiaHR0cHM6Ly9tb3p3YWxsZXQuczMuYW1hem9uYXdzLmNvbS9jYW1wYWlnbnMtbG9nb3MvNzgyMTRlYmMtOGUxMy00ZTBhLWI5YzktODRlZWU2MDhhNzJhX09uYm9hcmRpbmclMjBEZW1vIn0sImNvbnRlbnREZXNjcmlwdGlvbiI6eyJkZWZhdWx0VmFsdWUiOnsibGFuZ3VhZ2UiOiJlbi1VUyIsInZhbHVlIjoiQ2FtcGFpZ24gTG9nbyJ9fX0sImNhcmRUaXRsZSI6eyJkZWZhdWx0VmFsdWUiOnsibGFuZ3VhZ2UiOiJlbi1VUyIsInZhbHVlIjoiT25ib2FyZGluZyBEZW1vIn19LCJoZWFkZXIiOnsiZGVmYXVsdFZhbHVlIjp7Imxhbmd1YWdlIjoiZW4tVVMiLCJ2YWx1ZSI6IlRWOEFYVFU5WUpDSSJ9fSwibGlua3NNb2R1bGVEYXRhIjp7InVyaXMiOlt7InVyaSI6Imh0dHBzOi8vYXBwLm1vendhbGxldC5jb20vcGFzcy1sb2dpbj9wYXNzSWQ9VFY4QVhUVTlZSkNJJmNhbXBhaWduSWQ9NzgyMTRlYmMtOGUxMy00ZTBhLWI5YzktODRlZWU2MDhhNzJhJnRva2VuSWQ9MjE5MjMzNzIzMTEyNzQ3NzY1MjU1NDE5MTcyMjU2MjU1NzUyODkyNjQ5MDExNzY4MDAwNTc3MDI4NjQ1MDcwMDMyMjA4NzczNDQ2MzYmZm9yY2U9dHJ1ZSIsImlkIjoibG9naW4tbGluayIsImRlc2NyaXB0aW9uIjoiTWFuYWdlIERpZ2l0YWwgQXNzZXQiLCJsb2NhbGl6ZWREZXNjcmlwdGlvbiI6eyJkZWZhdWx0VmFsdWUiOnsibGFuZ3VhZ2UiOiJlbi1VUyIsInZhbHVlIjoiTWFuYWdlIERpZ2l0YWwgQXNzZXQifX19XX0sInRleHRNb2R1bGVzRGF0YSI6W3siaWQiOiJ0b2tlbi1uYW1lIiwiaGVhZGVyIjoiQ09MTEVDVElCTEVTIiwiYm9keSI6IlNvbWUgUGljdHVyZSBGb3IgWW91In0seyJpZCI6InRva2VuLW93bmVyc2hpcCIsImhlYWRlciI6IkFNT1VOVCIsImJvZHkiOiIxIn0seyJpZCI6Im93bmVkLWJ5IiwiaGVhZGVyIjoiT1dORUQgQlkiLCJib2R5IjoiKioqKiA3ZDJiIn0seyJpZCI6InRva2VuLWRlc2NyaXB0aW9uIiwiaGVhZGVyIjoiQ09MTEVDVElCTEVTIERFU0NSSVBUSU9OIiwiYm9keSI6IlNvbWUgZGVzY3JpcHRpb24ifSx7ImlkIjoiY2hhaW4iLCJoZWFkZXIiOiJTVEFOREFSRCIsImJvZHkiOiJQb2x5Z29uIE11bWJhaSAoRVJDLTExNTUpIn1dLCJiYXJjb2RlIjp7InR5cGUiOiJRUl9DT0RFIiwidmFsdWUiOiJUVjhBWFRVOVlKQ0kifSwiaGV4QmFja2dyb3VuZENvbG9yIjoiI2ZmZmZmZiIsImhlcm9JbWFnZSI6eyJzb3VyY2VVcmkiOnsidXJpIjoiaHR0cHM6Ly9tb3p3YWxsZXQuczMuYW1hem9uYXdzLmNvbS90b2tlbi1pbWFnZXMvNV8weDBiNTlmZGU3ZmJkYzg0NTFlZDZmYmJkNDZlYmI5OTljNDEzOGExZjZfMjE5MjMzNzIzMTEyNzQ3NzY1MjU1NDE5MTcyMjU2MjU1NzUyODkyNjQ5MDExNzY4MDAwNTc3MDI4NjQ1MDcwMDMyMjA4NzczNDQ2MzYifSwiY29udGVudERlc2NyaXB0aW9uIjp7ImRlZmF1bHRWYWx1ZSI6eyJsYW5ndWFnZSI6ImVuLVVTIiwidmFsdWUiOiJTb21lIFBpY3R1cmUgRm9yIFlvdSJ9fX19XX0sImlhdCI6MTY5MzkxOTg2NH0.mMyNnmwNKXOLl9EAiLRNDtHSFKGBcW4e3c1AQohHu3M2_R0y8-i59-vkCdcH0Ny0BAGXVrlgK8pd3KhnVn6S2cbSkqBayDc46XQ4vWhjmoh5FEpRm7x6-Kb2kErw7ykrnLgCln0P-mQTE8SvIdUuTJmekUokph92vWYIS3Xsr3r6b-zZLiFdl-OYYzHg62LCBBfcdOcBriB7qol2nUb-1COsTBU2eK2_pEoJXq237ngCZIoCpzOnTG8D5X67RNx6ANWZ0GdZsYaGm_Uz5ooBLe5d_vVA2l9tIkuci_tfZSAypIE9Tl0BhZwdqhl1UrsfegFeita_mMShyDT8bGyNQg?pli=1",

    // this is a replacement url
    val fakeWalletAndroidUrl: String = "https://www.example.com",


    // device node
    val deviceAttrTypePhone: String = "Phone",
    val deviceAttrTypeTablet: String = "Tablet",
    val deviceAttrTypeAll: String = "All",

    // ContactVFCUrl node
    val contactVCFUrl: String = "https://file.mozverse.com/9c48b7c0-2b71-4f28-97a9-8deca276ec1c/john-doe-vcf-ucl-uu-ny-t-xvj-swm-qk-3-i-vw-8-p-yc-xcsa-3-z-jh-vcf-ynGnFHZ7a16m4cn8BfH8cZ81DFU42rko.vcf",
    val vCardSerialized: String = "QkVHSU46VkNBUkQNClZFUlNJT046My4wDQpGTjtDSEFSU0VUPVVURi04OkphbWVzIExvZ2FuIEhvd2xldHQNCk47Q0hBUlNFVD1VVEYtODpIb3dsZXR0O0phbWVzO0xvZ2FuO0RyLjsNCk5JQ0tOQU1FO0NIQVJTRVQ9VVRGLTg6SmltbXkNClRFTDtUWVBFPUNFTEw6KDIxMikgMTExLTExMTENClJFVjoyMDIzLTEyLTEzVDE1OjQ4OjU4LjE0NVoNCkVORDpWQ0FSRA0K",

    // Digital Offer
    val digitalOfferUrl: String = "https://www.example.com/digital-offer",

    // Directions
    val directionsText: String = "Pariske Komune 8, Novi Beograd. Serbia",

    // locations
    val locations: String = "Starbucks",

    // Image
    val imageUrl: String = "https://www.gstatic.com/webp/gallery3/1.sm.png",

    // email
    val emailRecipient: String = "example@email.com",
    val emailSubject: String = "send email test subject",
    val emailBody: String = "send email test body",

    // local notification
    val localNotificationTitle: String = "Local Notification Title",
    val localNotificationContent: String = "Local Notification Content",
    val localNotificationActionDetailsUrl: String = "Local Notification Details Url",
    val localNotificationTranslationTitles: List<String> = listOf("Local Notification Translation Title 0" ,"Local Notification Translation Title 1"),
    val localNotificationTranslationContents: List<String> = listOf("Local Notification Translation Content 0" ,"Local Notification Translation Content 1"),
    val localNotificationTranslationActionDetailsUrls: List<String> = listOf("Local Notification Translation Action Url 0" ,"Local Notification Translation Action Url 1"),
    val localNotificationTranslationLanguages: List<String> = listOf("en", "es"),

    // pre permission notification
    val prePermissionNotificationTitle: String = "Pre Permission Notification Title",
    val prePermissionNotificationContent: String = "Pre Permission Notification Content",
    val prePermissionNotificationActionDetailsUrl: String = "Pre Permission Notification Details Url",
    val prePermissionNotificationTranslationTitles: List<String> = listOf("Pre Permission  Notification Translation Title 0" ,"Pre Permission  Notification Translation Title 1"),
    val prePermissionNotificationTranslationContents: List<String> = listOf("Pre Permission  Notification Translation Content 0" ,"Pre Permission  Notification Translation Content 1"),
    val prePermissionNotificationTranslationActionDetailsUrls: List<String> = listOf("Pre Permission  Notification Translation Action Url 0" ,"Pre Permission  Notification Translation Action Url 1"),
    val prePermissionNotificationTranslationLanguages: List<String> = listOf("en", "es"),

    // ics
    val icsUrl: String = "https://file.mozverse.com/9c48b7c0-2b71-4f28-97a9-8deca276ec1c/test-event-feb-1-ics-l7axu0Om0sOM0iYh2RMha5fw4WmAKcYD.ics",

    // duration
    val duration: Int = 120, // 60s
    val durationSeconds: Int = duration % 60,
    val durationMinutes: Int = (duration / 60) % 60,
    val durationHours: Int = (duration / (60 * 60)) % 60,

    val trackingUrl: String =
    //"https://events.moz-im.com/sdk?advertiserId=354&campaignId=289&adId=2c73fd9c-f19b-4f11-aeff-a9dee769549d&accountId=9c48b7c0-2b71-4f28-97a9-8deca276ec1c&creativeId=270&actionId=97&actionType=wallet",
        //"https://events.moz-im.com/pixel?event=start&p=9d6bdc4d7bf257ca6aaddf3413482a6974e7e8579e2ef655a7ee2a9b7cca65d2acb100e2bc2d6328ee8e4b99a90770396c4e9a784a007719745bbeb2b9018a77e205659a744d9644e46857f9de8bbf992939ff9ff6ee5f5a0832fd78f083b14d49f3710ec3b31905118b5090b755aa6b538d45acb7272e8ecefdb9491e587a66350f80e58c0c626b435a217cc2bd27d55316a6c660b6ab26f82188158e63a5eceeef587be96a5e535b4efde5726e7cfcf8cfed98148e8922683c6a90a9820687bb456ea0dde8163c7bec1206fe932b3c",
        "https://dev-events-im.mozverse.com/sdk?advertiserId=113&campaignId=85&adId=65f20c5d-4235-4e33-a793-786af6c4c9e6&accountId=4ad5bd49-30e1-433d-8914-aa2b1e339d6e&creativeId=232&actionId=340&actionType=contacts"
) {

    // im node

    fun buildXmlExtensionString(trigger: String, action: String) = """
        <IM adID="$adId">
            <IMA creativeID="$imaAttrCreativeId" trigger="$trigger" action="$action">
                <Duration>
                    <![CDATA[ ${String.format("%02d:%02d:%02d", durationHours, durationMinutes, durationSeconds)} ]]>
                </Duration>
                <Tracking>
                    <![CDATA[ $trackingUrl ]]>
                </Tracking>                
                <Data displayContact="$attrDisplayContact" displayCalendar="$attrDisplayCalendar" showLocalNotification="$attrShowLocalNotification" displayImage="$attrDisplayImage">
                    <PhoneNumber>
                        $dataPhoneNumber
                    </PhoneNumber>
                    <SmsBody>
                        $smsBody
                    </SmsBody>
                    <Url>
                        <![CDATA[$websiteUrl]]>
                    </Url>
                    <vCardSerialized>                  
                        <![CDATA[$vCardSerialized]]>
                    </vCardSerialized>
                    <ContactVCFUrl>                  
                        <![CDATA[$contactVCFUrl]]>
                    </ContactVCFUrl>
                    <Apps>
                        <Environment name="$environmentAttrNameApple">
                            <Device type="$deviceAttrTypePhone">
                                <AppID>
                                    <![CDATA[$appleStoreUrl1]]>
                                </AppID>
                            </Device>
                            <Device type="$deviceAttrTypeTablet">
                            <AppID>
                                <![CDATA[$appleStoreUrl2]]></AppID>
                            </Device>
                        </Environment>
                        <Environment name="$environmentAttrNameAndroid">
                            <Device type="$deviceAttrTypeAll">
                                <AppID>
                                    <![CDATA[$playStoreUrl]]>
                                </AppID>
                            </Device>                       
                        </Environment>
                    </Apps>
                    <Wallet>
                        <Environment name="$environmentAttrNameApple">
                            <Url>
                                <![CDATA[$walletAppleUrl]]>
                            </Url>
                        </Environment>
                        <Environment name="$environmentAttrNameAndroid">
                            <Url>
                                <![CDATA[${walletAndroidUrl}]]>
                            </Url>
                        </Environment>
                    </Wallet>
                    <EventICSUrl>
                        <![CDATA[$icsUrl]]>
                    </EventICSUrl>
                    <TokenDistributionURL>
                        <![CDATA[$digitalOfferUrl]]>
                    </TokenDistributionURL>
                    <Directions>
                        $directionsText
                    </Directions>
                    <ImageURL>
                        <![CDATA[$imageUrl]]>
                    </ImageURL>
                    <EmailRecipient>
                        $emailRecipient
                    </EmailRecipient>
                    <EmailSubject>
                        $emailSubject
                    </EmailSubject>
                    <EmailBody>
                        $emailBody
                    </EmailBody>
                    <Locations>
                        $locations
                    </Locations>
                </Data>
                 <LocalNotification>                   
                    <Title>
                        $localNotificationTitle
                    </Title>
                    <Content>
                        $localNotificationContent
                    </Content>
                    <ActionDetailsUrl>
                        $localNotificationActionDetailsUrl
                    </ActionDetailsUrl>
                    <Translation language="${localNotificationTranslationLanguages[0]}">
                        <Title>
                            ${localNotificationTranslationTitles[0]}
                        </Title>
                        <Content>
                            ${localNotificationTranslationContents[0]}
                        </Content>
                        <ActionDetailsUrl>
                            ${localNotificationTranslationActionDetailsUrls[0]}
                        </ActionDetailsUrl>
                    </Translation>
                    <Translation language="${localNotificationTranslationLanguages[1]}">
                        <Title>
                            ${localNotificationTranslationTitles[1]}
                        </Title>
                        <Content>
                            ${localNotificationTranslationContents[1]}
                        </Content>
                        <ActionDetailsUrl>
                            ${localNotificationTranslationActionDetailsUrls[1]}
                        </ActionDetailsUrl>
                    </Translation>
                </LocalNotification>
                <PrePermissionNotification>                   
                    <Title>
                        $prePermissionNotificationTitle
                    </Title>
                    <Content>
                        $prePermissionNotificationContent
                    </Content>
                    <ActionDetailsUrl>
                        $prePermissionNotificationActionDetailsUrl
                    </ActionDetailsUrl>
                    <Translation language="${prePermissionNotificationTranslationLanguages[0]}">
                        <Title>
                            ${prePermissionNotificationTranslationTitles[0]}
                        </Title>
                        <Content>
                            ${prePermissionNotificationTranslationContents[0]}
                        </Content>
                        <ActionDetailsUrl>
                            ${prePermissionNotificationTranslationActionDetailsUrls[0]}
                        </ActionDetailsUrl>
                    </Translation>
                    <Translation language="${prePermissionNotificationTranslationLanguages[1]}">
                        <Title>
                            ${prePermissionNotificationTranslationTitles[1]}
                        </Title>
                        <Content>
                            ${prePermissionNotificationTranslationContents[1]}
                        </Content>
                        <ActionDetailsUrl>
                            ${prePermissionNotificationTranslationActionDetailsUrls[1]}
                        </ActionDetailsUrl>
                    </Translation>
                </PrePermissionNotification>
           </IMA>
        </IM>
    """.trimIndent()


    fun createXmlVastString(trigger: String, action: String) = """
        <VAST>
            <Ad>
                <InLine>
                    <Extensions>               
                        <Extension type="$extensionAttrType">
                            ${buildXmlExtensionString(trigger, action)}
                        </Extension>
                    </Extensions>
                </InLine>
            </Ad>
        </VAST>
    """.trimIndent()

}