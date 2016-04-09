UPDATE SCHEDULE_DETAIL
SET KAKUTEI_SCHEDULE_DV = /*kakuteiScheduleDv*/'1',
KAKUTEI_BIKOU =  /*kakuteiBikou*/'1',
KAKUTEI_POZISHON_DV =  /*kakuteiPozishondv*/'1'
WHERE
SELECT_MONTH = /*selectMonth*/'1'
AND
FIRST_FG = /*firstFg*/'1' 