package edu.song.elasticsearch.related.data;

import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.song.elasticsearch.related.data.bean.Bill;

public class BillDataMock {

	public static enum FirstNameMale {
		Aaron, Abbott, Abel, Abner, Abraham, Adair, Adam, Addison, Adolph, Adonis, Adrian, Ahern, Alan, Albert, Aldrich, Alexander, Alfred, Alger, Algernon, Allen, Alston, Alva, Alvin, Alvis, Amos, Andre, Andrew, Andy, Angelo, Augus, Ansel, Antony, Antoine, Antonio, Archer, Archibald, Aries, Arlen, Armand, Armstrong, Arno, Arnold, Arthur, Arvin, Asa, Ashburn, Atwood, Aubrey, August, Augustine, Avery,

		Baldwin, Bancroft, Bard, Barlow, Barnett, Baron, Barrette, Barry, Bartholomew, Bart, Barton, Bartley, Basil, Bleacher, Beau, Beck, Ben, Benedict, Benjamin, Bennett, Benson, Berg, Berger, Bernard, Bernie, Bert, Breton, Bertram, Bevis, Bill, Bing, Bishop, Blair, Blake, Blithe, Bob, Booth, Borg, Boris, Bowen, Boyce, Boyd, Bradley, Brady, Brandon, Brian, Broderick, Brook, Bruce, Bruno, Buck, Burgess, Burke, Burn, Burton, Byron,

		Caesar, Calvin, Carey, Carl, Carr, Carter, Cash, Cecil, Cedric, Chad, Chinning, Chapman, Charles, Chisel, Chester, Christ, Christian, Christopher, Clare, Clarence, Clark, Claude, Clement, Cleveland, Cliff, Clifford, Clyde, Colbert, Colby, Colin, Conrad, Corey, Cornelius, Cornell, Craig, Curitis, Cyril,

		Dana, Daniel, Darcy, Darnell, Darren, Dave, David, Dean, Dempsey, Dennis, Derrick, Devin, Dick, Dominic, Don, Donahue, Donald, Douglas, Drew, Duke, Duncan, Dunn, Dwight, Dylan,

		Earl, Ed, Eden, Edgar, Edmund, Edison, Edward, Edwiin, Egbert, Eli, Elijah, Elliot, Ellis, Elmer, Elroy, Elton, Elvis, Emmanuel, Enoch, Eric, Ernest, Eugene, Evan, Everley,

		Fabian, Felix, Ferdinand, Fitch, Fitzgerald, Ford, Francis, Frank, Franklin, Frederic,

		Gabriel, Gale, Gary, Gavin, Gene, Geoffrey, Geoff, George, Gerald, Gilbert, Giles, Glenn, Goddard, Godfery, Gordon, Greg, Gregary, Griffith, Grover, Gustave, Guy,

		Hale, Haley, Hamiltion, Hardy, Harlan, Harley, Harold, Harriet, Harry, Harvey, Hayden, Heather, Henry, Herbert, Herman, Hilary, Hiram, Hobart, Hogan, Horace, Howar, Hubery, Hugh, Hugo, Humphrey, Hunter, Hyman,

		Ian, Ingram, Ira, Isaac, Isidore, Ivan, Ives,

		Jack, Jacob, Jared, Jason, Jay, Jeff, Jeffrey, Jeremy, Jerome, Jerry, Jesse, Jim, Jo, John, Jonas, Jonathan, Joseph, Joshua, Joyce, Julian, Julius, Justin,

		Keith, Kelly, Ken, Kennedy, Kenneth, Kent, Kerr, Kevin, Kim, King, Kirk, Kyle,

		Lambert, Lance, Larry, Lawrence, Leif, Len, Lennon, Leo, Leonard, Leopold, Les, Lester, Levi, Lewis, Lionel, Lou, Louis, Lucien, Luther, Lyle, Lyndon, Lynn,

		Magee, Malcolm, Mandel, Marcus, Marico, Mark, Marlon, Marsh, Marshall, Martin, Marvin, Matt, Matthew, Maurice, Max, Maximilian, Maxwell, Meredith, Merle, Michael, Michell, Mick, Mike, Miles, Milo, Monroe, Montague, Moore, Morgan, Mortimer, Morton, Murphy, Murray, Myron, Nat, Nathan, Nathaniel, Neil, Nelson, Newman, Nicholas, Nick, Nigel, Noah, Noel, Norman, Norton, Ogden, Oliver, Omar, Orville, Osborn, Oscar, Osmond, Oswald, Otis, Otto, Owen, Page, Parker, Paddy, Patrick, Paul, Payne, Perry, Pete, Peter, Phil, Philip, Porter, Prescott, Primo, Quentin, Quennel, Quincy, Quinn, Quintion, Rachel, Ralap, Randolph, Raymond, Reg, Regan, Reginald, Reuben, Rex, Richard, Robert, Robin, Rock, Rod, Roderick, Rodney, Ron, Ronald, Rory, Roy, Rudolf, Rupert, Ryan, Sam, Sampson, Samuel, Sandy, Saxon, Scott, Sean, Sebastian, Sid, Sidney, Silvester, Simon, Solomon, Spencer, Stan, Stanford, Stanley, Steven, Stev, Steward, Tab, Taylor, Ted, Ternence, Theobald, Theodore, Thomas, Tiffany, Tim, Timothy, Tobias, Toby, Todd, Tom, Tony, Tracy, Troy, Truman, Tyler, Tyrone, Ulysses, Upton, Uriah, Valentine, Verne, Vic, Victor, Vincent, Virgil, Vito, Vivian, Wade, Walker, Walter, Ward, Warner, Wayne, Webb, Webster, Wendell, Werner, Wilbur, Will, William, Willie, Winfred, Winston, Woodrow, Wordsworth, Wright, Wythe, Xavier, Yale, Yehudi, York, Yves, Zachary, Zebulon, Ziv
	}

	public static enum FirstNameFemale {
		Abigail, Ada, Adela, Adelaide, Afra, Agatha, Agnes, Alberta, Alexia, Alice, Alma, Althea, Alva, Amelia, Amy, Anastasia, Andrea, Ann, Anna, Annabelle, Antonia, April, Arabela, Arlene, Astrid, Atalanta, Athena, Audrey, Aurora,

		Barbara, Beatrice, Belinda, Bella, Belle, Bernice, Bertha, Beryl, Bess, Betsy, Betty, Beulah, Beverly, Blanche, Bblythe, Breenda, Bridget, Brook,

		Camille, Candance, Candice, Cara, Carol, Caroline, Catherine, Cathy, Cecilia, Celeste, Charlotte, Cherry, Cheryl, Chloe, Christine, Claire, Clara, Clementine, Constance, Cora, Coral, Cornelia,

		Daisy, Dale, Dana, Daphne, Darlene, Dawn, Debby, Deborah, Deirdre, Delia, Denise, Diana, Dinah, Dolores, Dominic, Donna, Dora, Doreen, Doris, Dorothy,

		Eartha, Eden, Edith, Edwina, Eileen, Elaine, Eleanore, Elizabeth, Ella, Ellen, Elma, Elsa, Elsie, Elva, Elvira, Emily, Emma, Erica, Erin, Esther, Eudora, Eunice, Evangeline, Eve, Evelyn,

		Faithe, Fanny, Fay, Flora, Florence, Frances, Freda, Frederica,

		Gabrielle, Gail, Gemma, Genevieve, Georgia, Geraldine, Gill, Giselle, Gladys, Gloria, Grace, Griselda, Gustave, Gwendolyn,

		Hannah, Harriet, Hazel, Heather, Hedda, Hedy, Helen, Heloise, Hilda, Hilary, Honey, Hulda,

		Ida, Ina, Ingrid, Irene, Iris, Irma, Isabel, Ivy,

		Jacqueline, JamieJane, Janet, Janice, Jean, Jill, Jo, Joa, Joanna, Joanne, Jocelyn, Jodie, Josephine, Joyce, Judith, Judy, Julia, Julie, Juliet, June,

		Kama, Karen, Katherine, Kay, Kelly, Kimberley, Kitty, Kristin,

		Laura, Laurel, Lauren, Lee, Lena, Leona, Lesley, Letitia, Lilith, Lillian, Lindsay, Lisa, Liz, Lorraine, Louise, Lydia, Lynn,

		Mabel, Madeline, Madge, Maggie, Mamie, Mandy, Marcia, Margaret, Marguerite, Maria, Marian, Marina, Marjorie, Martha, Martina, Mary, Maud, Maureen, Mavis, Maxine, Mag, May, Megan, Melissa, Meroy, Meredith, Merry, Michelle, Michaelia, Mignon, Mildred, Miranda, Miriam, Modesty, Moira, Molly, Mona, Monica, Muriel, Murray, Myra, Myrna,

		Nancy, Naomi, Natalie, Natividad, Nelly, Nicola, Nicole, Nina, Nora, Norma, Novia, Nydia,

		Octavia, Odelette, Odelia, Olga, Olive, Olivia, Ophelia,

		Pag, Page, Pamela, Pandora, Patricia, Paula, Pearl, Penelope, Penny, Philipppa, Phoebe, Phoenix, Phyllis, Polly, Poppy, Prima, Priscilla, Prudence,

		Queena, Quintina,

		Rachel, Rae, Renata, Renee, Rita, Riva, Roberta, Rosalind, Rose, Rosemary, Roxanne, Ruby, Ruth,

		Sabina, Sally, Sabrina, Salome, Samantha, Sandra, Sandy, Sara, Sarah, Sebastiane, Selena, Sharon, Sheila, Sherry, Shirley, Sibyl, Sigrid, Simona, Sophia, Spring, Stacey, Setlla, Stephanie, Susan, Susanna, Susie, Suzanne,

		Tabitha, Tammy, Teresa, Tess, Thera, Theresa, Tiffany, Tobey, Tracy, Trista, Truda,

		Ula, Una, Ursula,

		Valentina, Valerie, Vera, Verna, Veromca, Veronica, Victoria, Vicky, Violet, Virginia, Vita, Vivien,

		Wallis, Wanda, Wendy, Winifred, Winni,

		Xanthe, Xaviera, Xenia,

		Yedda, Yetta, Yvette, Yvonne
	}

	public static enum LastName {
		Abigail, Ada, Adela, Adelaide, Afra, Agatha, Agnes, Alberta, Alexia, Alice, Alma, Althea, Alva, Amelia, Amy, Anastasia, Andrea, Ann, Anna, Annabelle, Antonia, April, Arabela, Arlene, Astrid, Atalanta, Athena, Audrey, Aurora,

		Barbara, Beatrice, Belinda, Bella, Belle, Bernice, Bertha, Beryl, Bess, Betsy, Betty, Beulah, Beverly, Blanche, Bblythe, Breenda, Bridget, Brook,

		Camille, Candance, Candice, Cara, Carol, Caroline, Catherine, Cathy, Cecilia, Celeste, Charlotte, Cherry, Cheryl, Chloe, Christine, Claire, Clara, Clementine, Constance, Cora, Coral, Cornelia,

		Daisy, Dale, Dana, Daphne, Darlene, Dawn, Debby, Deborah, Deirdre, Delia, Denise, Diana, Dinah, Dolores, Dominic, Donna, Dora, Doreen, Doris, Dorothy,

		Eartha, Eden, Edith, Edwina, Eileen, Elaine, Eleanore, Elizabeth, Ella, Ellen, Elma, Elsa, Elsie, Elva, Elvira, Emily, Emma, Erica, Erin, Esther, Eudora, Eunice, Evangeline, Eve, Evelyn,

		Faithe, Fanny, Fay, Flora, Florence, Frances, Freda, Frederica,

		Gabrielle, Gail, Gemma, Genevieve, Georgia, Geraldine, Gill, Giselle, Gladys, Gloria, Grace, Griselda, Gustave, Gwendolyn,

		Hannah, Harriet, Hazel, Heather, Hedda, Hedy, Helen, Heloise, Hilda, Hilary, Honey, Hulda,

		Ida, Ina, Ingrid, Irene, Iris, Irma, Isabel, Ivy,

		Jacqueline, JamieJane, Janet, Janice, Jean, Jill, Jo, Joa, Joanna, Joanne, Jocelyn, Jodie, Josephine, Joyce, Judith, Judy, Julia, Julie, Juliet, June,

		Kama, Karen, Katherine, Kay, Kelly, Kimberley, Kitty, Kristin,

		Laura, Laurel, Lauren, Lee, Lena, Leona, Lesley, Letitia, Lilith, Lillian, Lindsay, Lisa, Liz, Lorraine, Louise, Lydia, Lynn,

		Mabel, Madeline, Madge, Maggie, Mamie, Mandy, Marcia, Margaret, Marguerite, Maria, Marian, Marina, Marjorie, Martha, Martina, Mary, Maud, Maureen, Mavis, Maxine, Mag, May, Megan, Melissa, Meroy, Meredith, Merry, Michelle, Michaelia, Mignon, Mildred, Miranda, Miriam, Modesty, Moira, Molly, Mona, Monica, Muriel, Murray, Myra, Myrna,

		Nancy, Naomi, Natalie, Natividad, Nelly, Nicola, Nicole, Nina, Nora, Norma, Novia, Nydia,

		Octavia, Odelette, Odelia, Olga, Olive, Olivia, Ophelia,

		Pag, Page, Pamela, Pandora, Patricia, Paula, Pearl, Penelope, Penny, Philipppa, Phoebe, Phoenix, Phyllis, Polly, Poppy, Prima, Priscilla, Prudence,

		Queena, Quintina,

		Rachel, Rae, Renata, Renee, Rita, Riva, Roberta, Rosalind, Rose, Rosemary, Roxanne, Ruby, Ruth,

		Sabina, Sally, Sabrina, Salome, Samantha, Sandra, Sandy, Sara, Sarah, Sebastiane, Selena, Sharon, Sheila, Sherry, Shirley, Sibyl, Sigrid, Simona, Sophia, Spring, Stacey, Setlla, Stephanie, Susan, Susanna, Susie, Suzanne,

		Tabitha, Tammy, Teresa, Tess, Thera, Theresa, Tiffany, Tobey, Tracy, Trista, Truda,

		Ula, Una, Ursula,

		Valentina, Valerie, Vera, Verna, Veromca, Veronica, Victoria, Vicky, Violet, Virginia, Vita, Vivien,

		Wallis, Wanda, Wendy, Winifred, Winni,

		Xanthe, Xaviera, Xenia,

		Yedda, Yetta, Yvette, Yvonne,

		Aaron, Abbott, Abel, Abner, Abraham, Adair, Adam, Addison, Adolph, Adonis, Adrian, Ahern, Alan, Albert, Aldrich, Alexander, Alfred, Alger, Algernon, Allen, Alston, Alvin, Alvis, Amos, Andre, Andrew, Andy, Angelo, Augus, Ansel, Antony, Antoine, Antonio, Archer, Archibald, Aries, Arlen, Armand, Armstrong, Arno, Arnold, Arthur, Arvin, Asa, Ashburn, Atwood, Aubrey, August, Augustine, Avery,

		Baldwin, Bancroft, Bard, Barlow, Barnett, Baron, Barrette, Barry, Bartholomew, Bart, Barton, Bartley, Basil, Bleacher, Beau, Beck, Ben, Benedict, Benjamin, Bennett, Benson, Berg, Berger, Bernard, Bernie, Bert, Breton, Bertram, Bevis, Bill, Bing, Bishop, Blair, Blake, Blithe, Bob, Booth, Borg, Boris, Bowen, Boyce, Boyd, Bradley, Brady, Brandon, Brian, Broderick, Bruce, Bruno, Buck, Burgess, Burke, Burn, Burton, Byron,

		Caesar, Calvin, Carey, Carl, Carr, Carter, Cash, Cecil, Cedric, Chad, Chinning, Chapman, Charles, Chisel, Chester, Christ, Christian, Christopher, Clare, Clarence, Clark, Claude, Clement, Cleveland, Cliff, Clifford, Clyde, Colbert, Colby, Colin, Conrad, Corey, Cornelius, Cornell, Craig, Curitis, Cyril, Daniel, Darcy, Darnell, Darren, Dave, David, Dean, Dempsey, Dennis, Derrick, Devin, Dick, Don, Donahue, Donald, Douglas, Drew, Duke, Duncan, Dunn, Dwight, Dylan,

		Earl, Ed, Edgar, Edmund, Edison, Edward, Edwiin, Egbert, Eli, Elijah, Elliot, Ellis, Elmer, Elroy, Elton, Elvis, Emmanuel, Enoch, Eric, Ernest, Eugene, Evan, Everley,

		Fabian, Felix, Ferdinand, Fitch, Fitzgerald, Ford, Francis, Frank, Franklin, Frederic,

		Gabriel, Gale, Gary, Gavin, Gene, Geoffrey, Geoff, George, Gerald, Gilbert, Giles, Glenn, Goddard, Godfery, Gordon, Greg, Gregary, Griffith, Grover, Guy,

		Hale, Haley, Hamiltion, Hardy, Harlan, Harley, Harold, Harry, Harvey, Hayden, Henry, Herbert, Herman, Hiram, Hobart, Hogan, Horace, Howar, Hubery, Hugh, Hugo, Humphrey, Hunter, Hyman,

		Ian, Ingram, Ira, Isaac, Isidore, Ivan, Ives,

		Jack, Jacob, Jared, Jason, Jay, Jeff, Jeffrey, Jeremy, Jerome, Jerry, Jesse, Jim, John, Jonas, Jonathan, Joseph, Joshua, Julian, Julius, Justin,

		Keith, Ken, Kennedy, Kenneth, Kent, Kerr, Kevin, Kim, King, Kirk, Kyle,

		Lambert, Lance, Larry, Lawrence, Leif, Len, Lennon, Leo, Leonard, Leopold, Les, Lester, Levi, Lewis, Lionel, Lou, Louis, Lucien, Luther, Lyle, Lyndon,

		Magee, Malcolm, Mandel, Marcus, Marico, Mark, Marlon, Marsh, Marshall, Martin, Marvin, Matt, Matthew, Maurice, Max, Maximilian, Maxwell, Merle, Michael, Michell, Mick, Mike, Miles, Milo, Monroe, Montague, Moore, Morgan, Mortimer, Morton, Murphy, Myron, Nat, Nathan, Nathaniel, Neil, Nelson, Newman, Nicholas, Nick, Nigel, Noah, Noel, Norman, Norton, Ogden, Oliver, Omar, Orville, Osborn, Oscar, Osmond, Oswald, Otis, Otto, Owen, Parker, Paddy, Patrick, Paul, Payne, Perry, Pete, Peter, Phil, Philip, Porter, Prescott, Primo, Quentin, Quennel, Quincy, Quinn, Quintion, Ralap, Randolph, Raymond, Reg, Regan, Reginald, Reuben, Rex, Richard, Robert, Robin, Rock, Rod, Roderick, Rodney, Ron, Ronald, Rory, Roy, Rudolf, Rupert, Ryan, Sam, Sampson, Samuel, Saxon, Scott, Sean, Sebastian, Sid, Sidney, Silvester, Simon, Solomon, Spencer, Stan, Stanford, Stanley, Steven, Stev, Steward, Tab, Taylor, Ted, Ternence, Theobald, Theodore, Thomas, Tim, Timothy, Tobias, Toby, Todd, Tom, Tony, Troy, Truman, Tyler, Tyrone, Ulysses, Upton, Uriah, Valentine, Verne, Vic, Victor, Vincent, Virgil, Vito, Vivian, Wade, Walker, Walter, Ward, Warner, Wayne, Webb, Webster, Wendell, Werner, Wilbur, Will, William, Willie, Winfred, Winston, Woodrow, Wordsworth, Wright, Wythe, Xavier, Yale, Yehudi, York, Yves, Zachary, Zebulon, Ziv

	}

	public static enum EmailAddress {
		sohu, yahoo, thinkmaill, qq, sina, outlook, sogou, yeah, gmail, foxmail, aliyun, tom, hotmail
	}

	public static enum City {
		Montgomery, Juneau, Phoenix, Little_Rock, Sacramento, Denver, Hartford, Dover, Tallahassee, Atlanta, Honolulu, Boise, Springfield, Indianapolis, Des_Moines, Topeka, Frankfort, Baton_Rouge, Augusta, Annapolis, Boston, Lansing, St_Paul, Jackson, Jefferson_City, Helena, Lincoln, Carson_City, Concord, Trenton, Santa_Fe, Albany, Raleigh, Bismarck, Columbus, Oklahoma_City, Salem, Harrisburg, Providence, Columbia, Pierre, Nashville, Austin, Salt_Lake_City, Montpelier, Richmond, Olympia, Charleston, Madison, Cheyenne
	}

	public static enum State {
		AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS, MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RL, SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY
	}

	public static enum Employer {
		xurban, accel, accidency, accruex, accufarm, accupharm, accuprint, accusage, acium, aclima, acrodance, acruex, acumentor, acusage, adornica, aeora, affluex, amril, amtap, amtas, anacho, anarco, andershun, andryx, animalia, anivet, anixang, anocha, apex, apexia, apextri, applica, applidec, applideck, aquacine, aquafire, aquamate, aquasseur, aquasure, aquazure, aquoavo, architax, arctiq, artiq, artworlds, asimiline, assistia, assistix, assitia, assurity, atgen, atomica, austech, austex, autograte, automon, avenetro, avit, balooba, baluba, barkarama, beadzza, bedder, bedlam, besto, bezal, bicol, biflex, billmed, biohab, biolive, biospan, biotica, bisba, bitendrex, bitrex, bittor, bizmatic, blanet, bleeko, bleendot, bluegrain, bluplanet, blurrybus, boilcat, boilicon, boink, bolax, bostonic, bovis, brainclip, brainquil, bristo, bugsall, bulljuice, bullzone, bunga, buzzmaker, buzzness, buzzopia, buzzworks, bytrex, cablam, calcu, calcula, callflex, candecor, canopoly, capscreen, caxt, cedward, cemention, centice, centree, centregy, centrexin, centuria, ceprene, chillium, chorizon, cinaster, cincyr, cinesanct, cipromox, circum, coash, codact, codax, cofine, cogentry, cognicode, colaire, collaire, columella, combogen, combogene, combot, comcubine, comcur, comdom, comfirm, comstar, comstruct, comtent, comtest, comtext, comtour, comtours, comtract, comtrail, comtrak, comtrek, comvene, comverges, comvex, comvey, comveyer, comveyor, comvoy, concility, conferia, confrenzy, conjurica, corecom, corepan, coriander, cormoran, corporana, corpulse, cosmetex, cosmosis, cowtown, crustatia, cubicide, cubix, cuizine, cujo, cyclonica, cytrak, cytrek, cytrex, dadabase, daido, daisu, dancerity, dancity, danja, darwinium, datacator, datagen, datagene, daycore, decratex, deepends, delphide, deminimum, dentrex, deviltoe, digial, digifad, digigen, digigene, diginetic, digiprint, digique, digirang, digitalus, dognosis, dognost, dogspa, dogtown, dragbot, dreamia, duflex, duoflex, dymi, dyno, earbang, eargo, earthmark, earthplex, earthpure, earthwax, earwax, ebidco, eclipsent, eclipto, ecolight, ecosys, ecrater, ecratic, ecraze, ecstasia, edecine, egypto, electonic, elemantra, elentrix, elita, elpro, emergent, emoltra, empirica, emtrac, emtrak, enaut, endicil, endipin, endipine, enerforce, enersave, enersol, enervate, enjola, enomen, enormo, enquility, entality, enthaze, entogrok, entroflex, entropix, envire, eplode, eplosion, equicom, equitax, equitox, ersum, escenta, eschoir, essensia, eternis, euron, eventage, eventex, eventix, everest, evidends, ewaves, eweville, exerta, exiand, exoblue, exodoc, exoplode, exosis, exospace, exospeed, exostream, exoswitch, exotechno, exoteric, exovent, exozent, exposa, extragen, extragene, extrawear, extremo, extro, eyeris, eyewax, ezent, ezentia, fanfare, fangold, farmage, farmex, fiberox, fibrodyne, filodyne, firewax, fishland, fitcore, fleetmix, flexigen, flotonic, flum, flumbo, flyboyz, fortean, fossiel, franscene, freakin, frenex, frolix, frosnex, fuelton, fuelworks, furnafix, furnigeer, furnitech, futuris, futurity, futurize, gadtron, gallaxia, gaptec, gazak, geeketron, geekfarm, geekko, geekmosis, geeknet, geekol, geekola, geekology, geekosis, geekular, geekus, geekwagon, geeky, genekom, genesynk, genmex, genmom, genmy, geofarm, geoform, geoforma, geologix, geostele, gink, ginkle, ginkogene, glasstep, gleamink, globoil, gluid, glukgluk, gogol, goko, golistic, gology, gonkle, gorganic, gracker, grainspot, greeker, grok, gronk, grupoli, gushkool, gynk, gynko, hairport, halap, handshake, harmoney, hatology, hawkster, helixo, hinway, hivedom, homelux, hometown, honotron, hopeli, hotcakes, housedown, hydrocom, hyplex, icology, idealis, idego, idetica, illumity, imageflow, imaginart, imant, imkan, immunics, imperium, incubus, indexia, inear, infotrips, injoy, inquala, inrt, insectus, insource, insuresys, insurety, insurity, insuron, interfind, intergeek, interloo, interodeo, intradisk, intrawear, inventure, iplax, irack, isbol, isis, isodrive, isologia, isologica, isologics, isologix, isonus, isoplex, isopop, isosphere, isostream, isosure, isoswitch, isoternia, isotrack, isotronic, izzby, jamnation, jasper, jetsilk, jimbies, joviold, jumpstack, junipoor, kage, kaggle, kangle, katakana, keeg, keengen, kegular, kenegy, kengen, kidgrease, kidstock, kiggle, kindaloo, kinetica, kineticut, kiosk, klugger, kneedles, knowlysis, koffee, kog, kongene, kongle, konnect, koogle, kozgene, krag, kraggle, krog, kyagoro, kyaguru, letpro, lexicondo, limage, limozen, lingoage, liquicom, liquidoc, locazone, lotron, lovepad, ludak, lumbrex, lunchpad, lunchpod, luxuria, lyria, lyrichord, macronaut, magmina, magnafone, magneato, magnemo, magnina, maineland, makingway, malathion, mangelica, manglo, mantrix, mantro, manufact, marketoid, maroptic, marqet, martgo, marvane, matrixity, maxemia, maximind, mazuda, medalert, medcom, medesign, medicroix, medifax, mediot, medmex, megall, melbacor, memora, menbrain, metroz, microluxe, micronaut, minga, miraclis, miracula, mitroc, mixers, mobildata, moltonic, momentia, mondicil, moreganic, motovate, multiflex, multron, musanpoly, musaphics, musix, myopium, namebox, namegen, navir, naxdis, nebulean, neocent, neptide, netagy, netbook, neteria, netility, netplax, netplode, netropic, netur, neurocell, newcube, nexgene, nikuda, nimon, nipaz, niquent, nitracyr, nixelt, noralex, norali, norsul, norsup, nspire, nurali, nurplex, nutralab, oatfarm, obliq, obones, oceanica, octocore, ohmnet, olucore, olympix, omatom, omnigog, ontagene, ontality, opportech, opticall, opticom, opticon, optique, optyk, orbalix, orbaxter, orbean, orbiflex, orbin, orbixtar, orboid, organica, oronoko, otherside, otherway, oulu, ovation, overfork, overplex, ovium, ovolo, ozean, panzent, papricut, paprikut, paragonia, parcoe, parleynet, pasturia, pathways, pawnagra, pearlesex, pearlessa, perkle, peticular, petigems, pharmacon, pharmex, pheast, pholio, phormula, photobin, phuel, pigzart, pivitol, plasmos, plasmosis, plasmox, plasto, playce, plexia, plutorque, podunk, polarax, polaria, polarium, poochies, portaline, portalis, portica, portico, poshome, powernet, premiant, primordia, printspan, prismatic, proflex, progenex, prosely, prosure, protodyne, providco, prowaste, proxsoft, pulze, puria, pushcart, pyramax, pyrami, pyramia, pyramis, qaboos, qiao, qimonk, qnekt, qot, quadeebo, quailcom, qualitern, qualitex, quantalia, quantasis, quarex, quarmony, quarx, quilch, quility, quilk, quilm, quiltigen, quinex, quintity, quizka, quizmo, quonata, quonk, quordate, quotezart, radiantix, rameon, ramjob, realmo, realysis, recognia, recrisys, recritube, remold, remotion, renovize, repetwire, retrack, retrotex, reversus, roboid, rockabye, rocklogic, rockyard, rodemco, rodeocean, rodeology, rodeomad, ronbert, ronelon, rooforia, rotodyne, roughies, rubadub, rugstars, sarasonic, satiance, savvy, scentric, scenty, schoolio, sealoud, securia, senmao, senmei, sensate, sentia, sequitur, shadease, shepard, shopabout, signidyne, signity, silodyne, singavera, skinserve, skybold, skyplex, slambda, slax, slofast, sloganaut, slumberia, snacktion, snips, snorus, snowpoke, softmicro, solaren, solgan, songbird, songlines, sonique, soprano, spacewax, speedbolt, spherix, splinx, sportan, springbee, squish, steelfab, steeltab, stelaecor, stockpost, straloy, stralum, strezzo, strozen, stucco, sulfax, sultrax, sultraxin, sunclipse, supportal, supremia, surelogic, suremax, sureplex, suretech, sustenza, sybixtex, synkgen, syntac, talae, talendula, talkalot, talkola, tasmania, techade, techmania, techtrix, telepark, telequiet, tellifly, telpod, temorak, teraprene, terascape, terragen, terrago, terrasys, tersanki, tetak, tetratrex, thredz, tingles, tourmania, toyletry, translink, trasola, tri, tribalog, tripsch, trollery, tropoli, tropolis, tsunamia, tubalum, tubesys, turnabout, turnling, twiggery, twiist, typhonica, uberlux, ultrasure, ultrimax, uncorp, undertap, uneeq, uni, unia, unisure, uniworld, unq, updat, uplinx, urbanshee, utara, utarian, uxmox, valpreal, valreda, vantage, velity, velos, vendblend, venoflex, veraq, verbus, vertide, verton, vetron, viagrand, viagreat, viasia, vicon, vidto, vinch, viocular, virva, virxo, visalia, visualix, vitricomp, vixo, voipa, volax, voratak, vortexaco, vurbo, waab, waretel, waterbaby, wazzu, webiotic, wrapture, xanide, xelegyl, xerex, xeronk, xiix, xinware, xixan, xleen, xoggle, xplor, xsports, xth, xumonk, xylar, xymonk, xyqag, yogasm, yurture, zaggle, zaggles, zaj, zanilla, zanity, zanymax, zaphire, zappix, zaya, zboo, zeam, zedalis, zenco, zenolux, zensor, zensure, zensus, zenthall, zentia, zentility, zentime, zentix, zentry, zentury, zepitope, zerbina, zerology, zialactic, zidant, zidox, ziggles, zilch, zilencio, zilidium, zilla, zillacom, zillacon, zillactic, zilladyne, zillan, zillanet, zillar, zillatide, zillidium, zilodyne, zilphur, zinca, ziore, zipak, zisis, zizzle, zoarere, zogak, zoid, zoinage, zolar, zolarex, zolarity, zolavo, zomboid, zork, zorromop, zosis, zounds, zoxy, zuvy, zyple, zytrac, zytrax, zytrek, zytrex,
	}

	public static enum Address {
		bergen, lincoln, mill, schenck, bay, bushwick, chester, fleet, herkimer, highland, howard, irving, jackson, lake, lott, ocean, prospect, williams, albemarle, arlington, bartlett, bayview, bedford, blake, boerum, bragg, brighton, brightwater, brooklyn, butler, campus, caton, chestnut, church, clinton, colonial, columbia, cumberland, cypress, debevoise, division, dunne, duryea, eldert, elliott, elm, farragut, fillmore, franklin, furman, garden, grand, grove, hamilton, hampton, harbor, harrison, hart, hendrickson, homecrest, hubbard, jefferson, jerome, johnson, kane, kenmore, kensington, kent, kings, lafayette, laurel, lawrence, lefferts, lewis, linden, lloyd, locust, madison, manhattan, maple, matthews, meserole, miller, monroe, montague, montauk, montgomery, moore, nassau, navy, neptune, newkirk, oriental, ovington, oxford, perry, pierrepont, placez, plaza, poplar, quentin, remsen, ridge, ridgewood, rockaway, roosevelt, royce, ryder, seagate, seaview, sedgwick, seigel, square, stillwell, story, stryker, sullivan, sunnyside, suydam, tapscott, tompkins, union, vanderbilt, vanderveer, vandervoort, varick, vermont, verona, village, willoughby, willow, wilson, wyckoff, wythe, abbey, aberdeen, adams, adelphi, adler, agate, ainslie, aitken, alabama, albany, albee, alice, allen, alley, alton, amber, amboy, amersfort, amherst, amity, anchorage, anna, anthony, apollo, applegate, argyle, arion, arkansas, ash, ashford, ashland, aster, atkins, atlantic, auburn, aurelia, autumn, aviation, bainbridge, balfour, baltic, bancroft, bank, banker, banner, barbey, barlow, barwell, bassett, batchelder, bath, battery, baughman, bayard, baycliff, beach, beacon, beadel, beard, beaumont, beaver, beayer, bedell, beekman, belmont, belvidere, bennet, benson, berkeley, berriman, berry, bethel, beverley, beverly, bevy, bijou, billings, bills, bleecker, bliss, boardwalk, bogart, bokee, bond, borinquen, bouck, bowery, bowne, box, boynton, bradford, branton, brevoort, bridge, bridgewater, brigham, bristol, broadway, broome, brown, bryant, buffalo, bulwer, burnett, bush, cadman, calder, calyer, cambridge, cameron, canal, canarsie, canda, canton, carlton, carroll, cass, catherine, cedar, celeste, central, centre, channel, chapel, charles, chase, chauncey, cheever, cherry, christopher, clara, clarendon, clark, clarkson, classon, claver, clay, clermont, cleveland, clifford, clifton, clove, clymer, cobek, coffey, colby, coleman, coleridge, coles, colin, college, columbus, commerce, commercial, concord, conduit, congress, conklin, conover, conselyea, conway, cook, cooke, cooper, corbin, cornelia, cortelyou, courtr, cove, coventry, covert, cox, coyle, cozine, cranberry, crawford, creamer, crescent, crooke, cropsey, crosby, croton, crown, crystal, cyrus, dahill, dahl, dahlgreen, dakota, danforth, dank, dare, dean, dearborn, decatur, degraw, dekalb, dekoven, delevan, delmonico, dennett, denton, desmond, devoe, devon, dewey, dewitt, diamond, dictum, dikeman, dinsmore, ditmars, ditmas, dobbin, dodworth, dooley, doone, dorchester, dorset, doscher, doughty, douglass, dover, downing, drew, driggs, duffield, dumont, dunham, dupont, durland, dwight, eagle, eastern, eaton, ebony, eckford, elizabeth, ellery, elmwood, elton, emerald, emerson, emmons, empire, engert, erasmus, erskine, essex, estate, etna, euclid, evans, everett, evergreen, everit, exeter, fair
	}

	public static enum Place {
		Avenue, Place, Court, Street, Walk, Lane, Loop, Road, Boulevard, Terrace, Parkway
	}

	/**
	 * 用于模拟插入的数据，效率约为200条/ms（单线程）
	 * @param number 模拟数量
	 * @param account_from id起始数
	 * @return 模拟的数据
	 */
	public static List<Bill> Mock(int number, int account_from) {

		int FirstNameMaleLen = FirstNameMale.values().length;
		int FirstNameFemaleLen = FirstNameFemale.values().length;
		int LastNameLen = LastName.values().length;
		int EmailAddressLen = EmailAddress.values().length;
		int EmployerLen = Employer.values().length;
		int AddressLen = Address.values().length;
		int PlaceLen = Place.values().length;

		String firstName, lastName, gender;
		long balance, age;
		String address, email, city, state, employer;
		int account_number;

		List<Bill> list = new ArrayList<Bill>();
		for (int count = 0; count < number; count++ , account_from++) {
			Bill bill = new Bill();
			
			account_number = account_from+1;
			// gender random
			int genderInt = new Random().nextInt(2);
			if (genderInt == 0) {
				gender = "M";
				firstName = FirstNameMale.values()[new Random().nextInt(FirstNameMaleLen)].toString();
			} else {
				gender = "F";
				firstName = FirstNameFemale.values()[new Random().nextInt(FirstNameFemaleLen)].toString(); // 从枚举中随机获取一个值
			}
			lastName = LastName.values()[new Random().nextInt(LastNameLen)].toString(); 
			int balanceLevel = new Random().nextInt(3) + 3;
			balance = new Random().nextInt(involutionBaseTen(balanceLevel));
			age = new Random().nextInt(25)+15;
			int cityInt = new Random().nextInt(50);
			city = City.values()[cityInt].toString();
			state = State.values()[cityInt].toString();

			email = firstName.toLowerCase() + lastName.toLowerCase() + "@"
					+ EmailAddress.values()[new Random().nextInt(EmailAddressLen)].toString() + ".com";
			Integer addressNum = new Random().nextInt(1000);
			address = addressNum.toString() + " " + Address.values()[new Random().nextInt(AddressLen)].toString() + " "
					+ Place.values()[new Random().nextInt(PlaceLen)].toString();
			employer = Employer.values()[new Random().nextInt(EmployerLen)].toString();

			bill.setFirstName(firstName);
			bill.setLastName(lastName);
			bill.setAddress(address);
			bill.setGender(gender);
			bill.setAccount_number(account_number);
			bill.setAge(age);
			bill.setBalance(balance);
			bill.setCity(city);
			bill.setState(state);
			bill.setEmployer(employer);
			bill.setEmail(email);

			list.add(bill);
		}
		
		return list;
	}

	private static int involutionBaseTen(int exponent) {
		int power = 1;
		for (int i = 0; i < exponent; i++)
			power *= 10;

		return power;
	}

	public static void main(String[] args) {
		System.out.println(Mock(10, 0));
		
	}
}
