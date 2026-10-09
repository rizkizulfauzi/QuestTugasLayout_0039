package com.example.praktugas

import androidx.compose.ui.text.font.FontFamily
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
private fun spResource(@DimenRes id: Int): TextUnit = dimensionResource(id).value.sp

@Composable
fun KartuProfil(
    @StringRes nama: Int,
    @StringRes alamat: Int,
    @ColorRes warnaKartu: Int,
    @ColorRes warnaAlamat: Int,
    modifier: Modifier = Modifier,
    @StringRes telepon: Int? = null,
    @DimenRes ukuranNama: Int = R.dimen.font_nama,
    fontNama: FontFamily = FontFamily.Default,
    bobotNama: FontWeight = FontWeight.Bold
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_kartu)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_kartu)),
        colors = CardDefaults.cardColors(containerColor = colorResource(warnaKartu))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoUmy()
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = dimensionResource(R.dimen.jarak_konten))
            ) {
                Text(
                    text = stringResource(nama),
                    fontSize = spResource(ukuranNama),
                    fontFamily = fontNama,
                    fontWeight = bobotNama,
                    color = colorResource(R.color.teks_nama)
                )
                if (telepon != null) {
                    Text(
                        text = stringResource(telepon),
                        fontSize = spResource(R.dimen.font_detail),
                        color = colorResource(R.color.teks_telp),
                        modifier = Modifier.padding(top = dimensionResource(R.dimen.jarak_teks))
                    )
                }
                Text(
                    text = stringResource(alamat),
                    fontSize = spResource(R.dimen.font_detail),
                    color = colorResource(warnaAlamat),
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.jarak_teks))
                )
            }
            LogoUmy()
        }
    }
}

@Composable
private fun LogoUmy() {
    Image(
        painter = painterResource(R.drawable.logo_umy),
        contentDescription = stringResource(R.string.desc_logo),
        modifier = Modifier
            .size(dimensionResource(R.dimen.ukuran_logo))
            .padding(dimensionResource(R.dimen.padding_logo))
    )
}

@Composable
fun ActivitasPertama(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = dimensionResource(R.dimen.padding_atas_layar))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.prodi),
            fontSize = spResource(R.dimen.font_prodi),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.univ),
            fontSize = spResource(R.dimen.font_univ)
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.jarak_judul)))

        KartuProfil(
            nama = R.string.nama_1,
            telepon = R.string.telp_1,
            alamat = R.string.alamat_1,
            warnaKartu = R.color.card_0_bg,
            warnaAlamat = R.color.teks_alamat_kuning,
            ukuranNama = R.dimen.font_nama_cursive,
            fontNama = FontFamily.Cursive,
            bobotNama = FontWeight.Normal
        )
        KartuProfil(
            nama = R.string.nama_2,
            telepon = R.string.telp_2,
            alamat = R.string.alamat_2,
            warnaKartu = R.color.card_1_bg,
            warnaAlamat = R.color.teks_alamat_kuning
        )
        KartuProfil(
            nama = R.string.nama_3,
            telepon = R.string.telp_3,
            alamat = R.string.alamat_3,
            warnaKartu = R.color.card_2_bg,
            warnaAlamat = R.color.teks_alamat_putih
        )
        KartuProfil(
            nama = R.string.nama_4,
            telepon = R.string.telp_4,
            alamat = R.string.alamat_4,
            warnaKartu = R.color.card_3_bg,
            warnaAlamat = R.color.teks_alamat_putih
        )
    }

}


