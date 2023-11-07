SELECT
concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) FILE_PATH

from USED_GOODS_FILE 
where BOARD_ID = (
    select BOARD_ID
    from USED_GOODS_BOARD 
    order by VIEWS desc
    limit 1
)
order by FILE_ID desc