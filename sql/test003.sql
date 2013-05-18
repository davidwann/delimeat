
SELECT COUNT(*) 
   FROM EmailAddresses a  
      JOIN WebsiteRegions b 
         ON b.website = a.website 
   WHERE a.website_type = 'homesfsbo' AND  
         a.contacted = FALSE AND  
         a.email NOT LIKE '%yahoo.com' AND 
         a.email NOT LIKE '%YAHOO.COM' AND 
         a.email NOT LIKE '%gmail.com' AND 
         a.email NOT LIKE '%GMAIL.COM' AND 
         a.email NOT LIKE '%aol.com' AND 
         a.email NOT LIKE '%AOL.COM' AND 
         a.email NOT LIKE '%msn.com' AND 
         a.email NOT LIKE '%MSN.COM' AND 
         a.email NOT LIKE '%hotmail.com' AND 
         a.email NOT LIKE '%HOTMAIL.COM'; 
		
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
   WHERE a.website_type = 'homesfsbo' AND  
         a.contacted = FALSE AND  
         a.email NOT LIKE '%yahoo.com' AND 
         a.email NOT LIKE '%YAHOO.COM' AND 
         a.email NOT LIKE '%gmail.com' AND 
         a.email NOT LIKE '%GMAIL.COM' AND 
         a.email NOT LIKE '%aol.com' AND 
         a.email NOT LIKE '%AOL.COM' AND 
         a.email NOT LIKE '%msn.com' AND 
         a.email NOT LIKE '%MSN.COM' AND 
         a.email NOT LIKE '%hotmail.com' AND 
         a.email NOT LIKE '%HOTMAIL.COM' 
   ORDER BY a.id 
   FETCH FIRST 1 ROW ONLY; 
		
