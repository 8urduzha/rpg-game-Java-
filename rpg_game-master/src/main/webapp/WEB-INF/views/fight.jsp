<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form class="m-5" method="POST" action="/fight/${hero.id}/${monster.id}">
    <div class="row">
        <div class="col-2 text-right">
            <span>HP</span>
            <p>${hero.currHP}/${hero.hitPoint}</p>
            <span>MP</span>
            <p>${hero.currMP}/${hero.manaPoint}</p>
            <span>ATK</span>
            <p>${hero.power}</p>
        </div>
        <div class="col-3">
            <img src="https://torrent-games.club/uploads/posts/2019-12/1576839149_56fg.jpg" width="100%" height="500px" alt="Герой" >
        </div>
        <div class="col-2">
            <div class="custom-control custom-radio">
                <input type="radio" id="customRadio1" name="choose" class="custom-control-input" value="1">
                <label class="custom-control-label" for="customRadio1">Hit</label>
            </div>
            <div class="custom-control custom-radio">
                <input type="radio" id="customRadio2" name="choose" class="custom-control-input" value="2">
                <label class="custom-control-label" for="customRadio2">Deff</label>
            </div>
            <div class="custom-control custom-radio">
                <input type="radio" id="customRadio3" name="choose" class="custom-control-input" value="3">
                <label class="custom-control-label" for="customRadio3">Use spell</label>
            </div>
            <%--<div class="custom-control custom-radio">--%>
                <%--<input type="radio" id="customRadio4" name="customRadio" class="custom-control-input" value="4">--%>
                <%--<label class="custom-control-label" for="customRadio4">4</label>--%>
            <%--</div>--%>
            <%--<div class="custom-control custom-radio">--%>
                <%--<input type="radio" id="customRadio5" name="customRadio" class="custom-control-input" value="5">--%>
                <%--<label class="custom-control-label" for="customRadio5">5</label>--%>
            <%--</div>--%>
        </div>
        <div class="col-3">
            <img src="https://torrent-igruha.org/uploads/posts/2019-10/1571068327_cover.jpg" width="100%" height="500px" alt="monster">
        </div>
        <div class="col-2">
            <span>HP</span>
            <p>${monster.currHP}/${monster.hitPoint}</p>
            <span>MP</span>
            <p>${monster.currMP}/${monster.manaPoint}</p>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-2 offset-5">
            <button type="submit" class="btn btn-success btn-lg">Fight</button>
        </div>
    </div>

</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>