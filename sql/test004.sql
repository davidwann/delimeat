
SELECT COUNT(*) 
   FROM EmailAddresses a  
      JOIN WebsiteRegions b 
         ON b.website = a.website 
   WHERE a.website_type = 'classifieds' AND 
         a.contacted = FALSE; 
		
SELECT a.id,   
       a.email, 
       a.ad_url, 
       a.ad_date, 
       a.contacted, 
       a.city, 
       a.city_sector,  
       a.cl_ad_category, 
       a.website, 
       a.website_type, 
       a.created, 
       a.modified, 
       b.region 
   FROM EmailAddresses a  
      JOIN WebsiteRegions b 
         ON b.website = a.website 
   WHERE a.website_type = 'classifieds' AND 
         a.contacted = FALSE 
   ORDER BY a.id 
   FETCH FIRST 1 ROW ONLY; 

