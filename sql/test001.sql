
SELECT a.city, 
       b.category, 
       a.city_sector, 
       a.website, 
       a.website_type, 
       a.spam 
   FROM Cities a 
      JOIN Categories b
         ON 1 = 1
   WHERE a.spam = 'yes' AND 
         a.website_type = 'homesfsbo' AND 
         b.category = 'reo'
UNION
SELECT a.city, 
       b.category, 
       a.city_sector, 
       a.website, 
       a.website_type, 
       a.spam 
   FROM Cities a 
      JOIN Categories b
         ON 1 = 1
   WHERE a.spam = 'yes' AND 
         a.website_type = 'classifieds'; 

